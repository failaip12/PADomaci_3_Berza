package rs.raf.pds.v5.z2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Offer;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.AskBidRequest;
import rs.raf.pds.v5.z2.gRPC.ClientId;
import rs.raf.pds.v5.z2.gRPC.DateRequest;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc.StocksServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;
import rs.raf.pds.v5.z2.gRPC.TransactionNotification;
import rs.raf.pds.v5.z2.gRPC.TransactionHistory;
import rs.raf.pds.v5.z2.gRPC.AddOfferResult;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Date;
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
        private ConcurrentMap<String, ConcurrentMap<String, Integer>> clientStockBalanceMap = new ConcurrentHashMap<String, ConcurrentMap<String, Integer>>();
        private ConcurrentMap<Stock, CopyOnWriteArrayList<Offer>> stockOffersMap = new ConcurrentHashMap<Stock, CopyOnWriteArrayList<Offer>>();
        private ConcurrentMap<String, StreamObserver<TransactionNotification>> idTransObserverMap = new ConcurrentHashMap<String, StreamObserver<TransactionNotification>>();
        private ConcurrentMap<Date, CopyOnWriteArrayList<TransactionHistory>> dateTransactionHistoryMap = new ConcurrentHashMap<Date, CopyOnWriteArrayList<TransactionHistory>>();
        private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        protected StocksServiceImpl() {
            initUnos();
            executorService.scheduleAtFixedRate(this::sendUpdates, 0, 10, TimeUnit.SECONDS);
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
            ConcurrentMap<String,Integer> map = new ConcurrentHashMap<String, Integer>();
            for (Stock stock : symbolStockMap.values()) {
            	map.put(stock.getSymbol(), 1000);
            }
            clientStockBalanceMap.put(clientId, map);
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
        public void getTransactionHistory(DateRequest request, StreamObserver<TransactionHistory> responseObserver) {
        	// Create a LocalDate object
        	Calendar calendar = Calendar.getInstance();
        	calendar.set(Calendar.YEAR, request.getYear());
        	calendar.set(Calendar.MONTH, request.getMonth() - 1);
        	calendar.set(Calendar.DAY_OF_MONTH, request.getDay());

        	// Convert Calendar to java.util.Date
        	Date date = truncateToDay(calendar.getTime());
        	CopyOnWriteArrayList<TransactionHistory> history = dateTransactionHistoryMap.get(date);
        	if(history != null) {
        		for (TransactionHistory event : history) {
        			responseObserver.onNext(event);
        		}
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
                        .sorted(request.getAsk() ? Comparator.comparingDouble(Offer::getStockPrice) : Comparator.comparingDouble(Offer::getStockPrice).reversed())
                        .limit(request.getNumberOfOffers())
                        .collect(Collectors.toList());

                for (Offer offer : offers) {
                    responseObserver.onNext(offer);
                }
            }
        }
        
        @Override
        public void addOffer(Offer request, StreamObserver<AddOfferResult> responseObserver) {
        	Stock stock = symbolStockMap.get(request.getSymbol());
            ConcurrentMap<String, Integer> clientBalance = clientStockBalanceMap.get(request.getClientId());
            int currentStockBalance = clientBalance.getOrDefault(request.getSymbol(), 0);
            StringBuilder responseMessage = new StringBuilder();

            if (!request.getBuy() && currentStockBalance < request.getNumberOfOffers()) {
                responseObserver.onNext(AddOfferResult.newBuilder()
					 .setMessage("Insufficient stocks to sell. You have " + currentStockBalance + " " + request.getSymbol() + " stocks").build());
                responseObserver.onCompleted();
                return;
            }
        	CopyOnWriteArrayList<Offer> offersList = stockOffersMap.get(stock);
            if (offersList == null) {
            	offersList = new CopyOnWriteArrayList<>();
            	offersList.add(request);
                stockOffersMap.put(stock, offersList);
                responseObserver.onNext(AddOfferResult.newBuilder()
   					 .setMessage("DONE").build());
	       		responseObserver.onCompleted();
                return;
            }
            
            CopyOnWriteArrayList<Offer> userOffers = stockOffersMap.values().stream()
                    .flatMap(List::stream)
                    .filter(offer -> offer.getClientId().equals(request.getClientId()) && offer.getSymbol().equals(request.getSymbol()))
                    .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

            for(Offer offer:userOffers) {
            	if(request.getBuy() == offer.getBuy()) {
                	responseMessage.append("You already have an existing order for " + request.getSymbol() + " It will be replaced with your new order.");
                	responseMessage.append("\n");
                	offersList.remove(offer);
            	}
            }
            
            List<Offer> offers = offersList.stream()
                    .filter(offer -> (!offer.getClientId().equals(request.getClientId()) && offer.getBuy() != request.getBuy() && offer.getStockPrice() == request.getStockPrice()))
                    .collect(Collectors.toList());
    		int numberOfOffersRequest = request.getNumberOfOffers();
            for (Offer offer:offers) {
            	if(numberOfOffersRequest == 0) {
            		break;
            	}
        		if(offer.getNumberOfOffers() > numberOfOffersRequest) {
        			int numberOfOffersOffer = offer.getNumberOfOffers() - numberOfOffersRequest;
            		Offer updatedOffer = Offer.newBuilder()
						 .setBuy(offer.getBuy())
						 .setClientId(offer.getClientId())
						 .setStockPrice(offer.getStockPrice())
						 .setSymbol(offer.getSymbol())
						 .setNumberOfOffers(numberOfOffersOffer).build();
            		//update offer in list with updated offer
            		offersList.set(offersList.indexOf(offer), updatedOffer);
            		if(request.getBuy()) {
            			currentStockBalance+=numberOfOffersRequest;
            			
            			ConcurrentMap<String, Integer> clientBalanceOffer = clientStockBalanceMap.get(offer.getClientId());
            			int oldOfferBalance = clientBalanceOffer.get(offer.getSymbol());
            			int newOfferBalance = oldOfferBalance - numberOfOffersRequest;
            			clientBalanceOffer.put(offer.getSymbol(), newOfferBalance);
            			clientStockBalanceMap.put(offer.getClientId(), clientBalanceOffer);
            			
            			notifyTransaction(request, updatedOffer); //TODO fix this 
            		}
            		else {
            			currentStockBalance-=numberOfOffersRequest;
            			
            			ConcurrentMap<String, Integer> clientBalanceOffer = clientStockBalanceMap.get(offer.getClientId());
            			int oldOfferBalance = clientBalanceOffer.get(offer.getSymbol());
            			int newOfferBalance = oldOfferBalance + numberOfOffersRequest;
            			clientBalanceOffer.put(offer.getSymbol(), newOfferBalance);
            			clientStockBalanceMap.put(offer.getClientId(), clientBalanceOffer);
            			
            			notifyTransaction(updatedOffer, request); //TODO fix this 
            		}
            		numberOfOffersRequest = 0;
        		}
        		else if(offer.getNumberOfOffers() < numberOfOffersRequest) {
                    numberOfOffersRequest -= offer.getNumberOfOffers();
                    Offer updatedRequest = Offer.newBuilder()
                            .setBuy(request.getBuy())
                            .setClientId(request.getClientId())
                            .setStockPrice(request.getStockPrice())
                            .setSymbol(request.getSymbol())
                            .setNumberOfOffers(numberOfOffersRequest).build();
            		//update request with updated offer, put it in list and remove offer from list
            		if(request.getBuy()) {
            			currentStockBalance+=offer.getNumberOfOffers();
            			
            			ConcurrentMap<String, Integer> clientBalanceOffer = clientStockBalanceMap.get(offer.getClientId());
            			int oldOfferBalance = clientBalanceOffer.get(offer.getSymbol());
            			int newOfferBalance = oldOfferBalance - offer.getNumberOfOffers();
            			clientBalanceOffer.put(offer.getSymbol(), newOfferBalance);
            			clientStockBalanceMap.put(offer.getClientId(), clientBalanceOffer);

                		notifyTransaction(updatedRequest, offer); //TODO fix this
            		}
            		else {
            			currentStockBalance-=offer.getNumberOfOffers();
            			
            			ConcurrentMap<String, Integer> clientBalanceOffer = clientStockBalanceMap.get(offer.getClientId());
            			int oldOfferBalance = clientBalanceOffer.get(offer.getSymbol());
            			int newOfferBalance = oldOfferBalance + offer.getNumberOfOffers();
            			clientBalanceOffer.put(offer.getSymbol(), newOfferBalance);
            			clientStockBalanceMap.put(offer.getClientId(), clientBalanceOffer);
            			

                		notifyTransaction(offer, updatedRequest); //TODO fix this
            		}
            		offersList.remove(offer);
        		}
        		else {
            		//remove offer from list
        			numberOfOffersRequest = 0;
        			
            		if(request.getBuy()) {
            			currentStockBalance+=offer.getNumberOfOffers();
            			
            			ConcurrentMap<String, Integer> clientBalanceOffer = clientStockBalanceMap.get(offer.getClientId());
            			int oldOfferBalance = clientBalanceOffer.get(offer.getSymbol());
            			int newOfferBalance = oldOfferBalance - offer.getNumberOfOffers();
            			clientBalanceOffer.put(offer.getSymbol(), newOfferBalance);
            			clientStockBalanceMap.put(offer.getClientId(), clientBalanceOffer);
            			
            			notifyTransaction(request, offer); //TODO fix this
            		}
            		else {
            			currentStockBalance-=offer.getNumberOfOffers();
            			
            			ConcurrentMap<String, Integer> clientBalanceOffer = clientStockBalanceMap.get(offer.getClientId());
            			int oldOfferBalance = clientBalanceOffer.get(offer.getSymbol());
            			int newOfferBalance = oldOfferBalance + offer.getNumberOfOffers();
            			clientBalanceOffer.put(offer.getSymbol(), newOfferBalance);
            			clientStockBalanceMap.put(offer.getClientId(), clientBalanceOffer);
            			
            			notifyTransaction(offer, request); //TODO fix this
            		}
        			offersList.remove(offer);
        		}
        		//notify both parties
            }
            if(numberOfOffersRequest > 0) {
                Offer updatedRequest = Offer.newBuilder()
                        .setBuy(request.getBuy())
                        .setClientId(request.getClientId())
                        .setStockPrice(request.getStockPrice())
                        .setSymbol(request.getSymbol())
                        .setNumberOfOffers(numberOfOffersRequest).build();
	            offersList.add(updatedRequest);
            }
            stockOffersMap.put(stock, offersList);
            
            clientBalance.put(request.getSymbol(), currentStockBalance);
            clientStockBalanceMap.put(request.getClientId(), clientBalance);
            responseMessage.append("DONE");
            
            responseObserver.onNext(AddOfferResult.newBuilder()
					 .setMessage(responseMessage.toString()).build());
    		responseObserver.onCompleted();
        }
        
        private void notifyTransaction(Offer buyOffer, Offer sellOffer) {
        	int test = 0;
        	if(buyOffer.getNumberOfOffers() > sellOffer.getNumberOfOffers()) {
        		test = sellOffer.getNumberOfOffers();
        	}
        	else {
        		test = buyOffer.getNumberOfOffers();
        	}
        	TransactionNotification transactionNotificationBuyer = TransactionNotification.newBuilder()
                    .setClientId(buyOffer.getClientId())
                    .setSymbol(buyOffer.getSymbol())
                    .setPrice(buyOffer.getStockPrice())
                    .setNumberOfShares(test)
                    .setBuy(true)
                    .build();
        	
        	TransactionNotification transactionNotificationSeller = TransactionNotification.newBuilder()
                    .setClientId(sellOffer.getClientId())
                    .setSymbol(sellOffer.getSymbol())
                    .setPrice(sellOffer.getStockPrice())
                    .setNumberOfShares(test)
                    .setBuy(false)
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
            long currentTimeMillis = System.currentTimeMillis();
        	TransactionHistory transactionHistory = TransactionHistory.newBuilder()
                    .setClientIdSeller(sellOffer.getClientId())
                    .setClientIdBuyer(buyOffer.getClientId())
                    .setSymbol(sellOffer.getSymbol())
                    .setPrice(sellOffer.getStockPrice())
                    .setNumberOfShares(test)
                    .setDateUnix(currentTimeMillis)
                    .build();
        	Date transactionDate = truncateToDay(new Date(currentTimeMillis));

        	CopyOnWriteArrayList<TransactionHistory> old = dateTransactionHistoryMap.get(transactionDate);
        	if (old == null) {
        	    old = new CopyOnWriteArrayList<TransactionHistory>();
        	}
        	old.add(transactionHistory);
        	dateTransactionHistoryMap.put(transactionDate, old);
        }
        
        private static Date truncateToDay(Date date) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        }
        
        private void sendUpdates() {
        	//System.out.println(clientStockBalanceMap);
        	//System.out.println(stockOffersMap);
        	System.out.println(dateTransactionHistoryMap);
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
