package rs.raf.pds.v5.z2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Offer;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.AskBidRequest;
import rs.raf.pds.v5.z2.gRPC.ClientId;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc.StocksServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;
import rs.raf.pds.v5.z2.gRPC.TransactionNotification;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StocksServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8090)
                .addService(new StocksServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }

    static class StocksServiceImpl extends StocksServiceImplBase {
        private ConcurrentMap<String, Stock> symbolStockMap = new ConcurrentHashMap<String, Stock>();
        private ConcurrentMap<String, CopyOnWriteArrayList<StreamObserver<Stock>>> subscriptions = new ConcurrentHashMap<String, CopyOnWriteArrayList<StreamObserver<Stock>>>();
        
        private ConcurrentMap<Stock, CopyOnWriteArrayList<Offer>> stockOffersMap = new ConcurrentHashMap<Stock, CopyOnWriteArrayList<Offer>>();
        private ConcurrentMap<String, StreamObserver<TransactionNotification>> idTransObserverMap = new ConcurrentHashMap<String, StreamObserver<TransactionNotification>>();
        private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        protected StocksServiceImpl() {
            initUnos();
            executorService.scheduleAtFixedRate(this::sendUpdates, 0, 5, TimeUnit.SECONDS);
        }

        private void initUnos() {
            for (Stock s : InitialData.initStocks()) {
                symbolStockMap.put(s.getSymbol(), s);
            }
        }
        
        @Override
        public void getUniqueId(Empty request, StreamObserver<ClientId> responseObserver) {
            String clientId = UUID.randomUUID().toString();
            
            ClientId response = ClientId.newBuilder()
                    .setClientId(clientId)
                    .build();
            
            // Send the response to the client
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        
        @Override
        public void subToTransactions(ClientId request, StreamObserver<TransactionNotification> responseObserver) {
        	idTransObserverMap.put(request.getClientId(), responseObserver);
        }
        
        @Override
        public void getAllStocks(Empty request, StreamObserver<Stock> responseObserver) {
            for (Stock stock : symbolStockMap.values()) {
                responseObserver.onNext(stock);
            }
            responseObserver.onCompleted();
        }
        
        @Override
        public void subscribeStocks(SubscribeUpit request, StreamObserver<Stock> responseObserver) {
            for (String symbol : request.getSymbolsList()) {
                subscriptions.computeIfAbsent(symbol.trim(), k -> new CopyOnWriteArrayList<StreamObserver<Stock>>()).add(responseObserver);
            }
        }
        
        
        @Override
        public void getOffers(AskBidRequest request, StreamObserver<Offer> responseObserver) {
            CopyOnWriteArrayList<Offer> offerList = stockOffersMap.get(symbolStockMap.get(request.getSymbol()));
            if (offerList != null) {
                List<Offer> offers = offerList.stream()
                        .filter(offer -> (request.getAsk() && !offer.getBuy()) || (!request.getAsk() && offer.getBuy()))
                        .sorted(Comparator.comparingDouble(Offer::getStockPrice))
                        .limit(request.getNumberOfOffers())
                        .collect(Collectors.toList());

                for (Offer offer : offers) {
                    responseObserver.onNext(offer);
                }
            }
        }


        
        @Override
        public void addOffer(Offer request, StreamObserver<Empty> responseObserver) {
        	Stock stock = symbolStockMap.get(request.getSymbol());
            CopyOnWriteArrayList<Offer> offers = stockOffersMap.get(stock);

            if (offers == null) {
            	offers = new CopyOnWriteArrayList<>();
                stockOffersMap.put(stock, offers);
            }
            Boolean found = false;
            for (Offer offer:offers) {
            	if(!offer.getClientId().equals(request.getClientId()) && offer.getBuy() != request.getBuy() && offer.getStockPrice() == request.getStockPrice()) {
            		int numberOfOffersOffer = 0;
            		if(offer.getNumberOfOffers() > request.getNumberOfOffers()) {
            			numberOfOffersOffer = offer.getNumberOfOffers() - request.getNumberOfOffers();
                		Offer updatedOffer = Offer.newBuilder()
   							 .setBuy(offer.getBuy())
   							 .setClientId(offer.getClientId())
   							 .setStockPrice(offer.getStockPrice())
   							 .setSymbol(offer.getSymbol())
   							 .setNumberOfOffers(numberOfOffersOffer).build();
                		//update offer in list with updated offer
                		notifyTransaction(request, updatedOffer); //TODO fix this 
                		offers.set(offers.indexOf(offer), updatedOffer);
            		}
            		else if(offer.getNumberOfOffers() < request.getNumberOfOffers()) {
                        numberOfOffersOffer = request.getNumberOfOffers() - offer.getNumberOfOffers();
                        Offer updatedRequest = Offer.newBuilder()
                                .setBuy(request.getBuy())
                                .setClientId(request.getClientId())
                                .setStockPrice(request.getStockPrice())
                                .setSymbol(request.getSymbol())
                                .setNumberOfOffers(numberOfOffersOffer).build();
                		//update request with updated offer, put it in list and remove offer from list
                		notifyTransaction(updatedRequest, offer); //TODO fix this 
                        offers.add(updatedRequest);
                        offers.remove(offer);
            		}
            		else {
                		//remove offer from list
            			notifyTransaction(offer, request); //TODO fix this 
                		offers.remove(offer);
            		}
            		//notify both parties
                    found = true;
            	}
            }
            if(!found) {
	            offers.add(request);
            }
    		responseObserver.onNext(Empty.newBuilder().build());
    		responseObserver.onCompleted();
            stockOffersMap.put(stock, offers);
        }
        
        private void notifyTransaction(Offer buyOffer, Offer sellOffer) {
        	TransactionNotification transactionNotificationBuyer = TransactionNotification.newBuilder()
                    .setClientId(buyOffer.getClientId())
                    .setSymbol(buyOffer.getSymbol())
                    .setPrice(buyOffer.getStockPrice())
                    .setNumberOfShares(buyOffer.getNumberOfOffers())
                    .build();
        	
        	TransactionNotification transactionNotificationSeller = TransactionNotification.newBuilder()
                    .setClientId(sellOffer.getClientId())
                    .setSymbol(sellOffer.getSymbol())
                    .setPrice(sellOffer.getStockPrice())
                    .setNumberOfShares(sellOffer.getNumberOfOffers())
                    .build();
        	
            StreamObserver<TransactionNotification> buyerObserver = idTransObserverMap.get(buyOffer.getClientId());
            StreamObserver<TransactionNotification> sellerObserver = idTransObserverMap.get(sellOffer.getClientId());

            // Notify the buyers and sellers
            if (buyerObserver != null) {
            	buyerObserver.onNext(transactionNotificationBuyer);
            }
            if (sellerObserver != null) {
            	sellerObserver.onNext(transactionNotificationSeller);
            }
        }
        
        private void sendUpdates() {
            for (String symbol : subscriptions.keySet()) {
                Stock stock = symbolStockMap.get(symbol);
                if (stock != null) {
                	CopyOnWriteArrayList<StreamObserver<Stock>> observers = subscriptions.get(symbol);
                    for (StreamObserver<Stock> observer : observers) {
                        observer.onNext(stock);
                    }
                }
            }
        }
    }
}
