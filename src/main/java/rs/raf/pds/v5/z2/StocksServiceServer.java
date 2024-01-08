package rs.raf.pds.v5.z2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.SellOffer;
import rs.raf.pds.v5.z2.gRPC.AskRequest;
import rs.raf.pds.v5.z2.gRPC.BidRequest;
import rs.raf.pds.v5.z2.gRPC.BuyOffer;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc.StocksServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        
        private ConcurrentMap<Stock, CopyOnWriteArrayList<SellOffer>> stockSellOffersMap = new ConcurrentHashMap<Stock, CopyOnWriteArrayList<SellOffer>>();
        private ConcurrentMap<Stock, CopyOnWriteArrayList<BuyOffer>> stockBuyOffersMap = new ConcurrentHashMap<Stock, CopyOnWriteArrayList<BuyOffer>>();
        private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        protected StocksServiceImpl() {
            initUnos();
            executorService.scheduleAtFixedRate(this::sendUpdates, 0, 30, TimeUnit.SECONDS);
        }

        private void initUnos() {
            for (Stock s : InitialData.initStocks()) {
                symbolStockMap.put(s.getSymbol(), s);
            }
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
        public void getBuyOffers(BidRequest request, StreamObserver<BuyOffer> responseObserver) {
        	CopyOnWriteArrayList<BuyOffer> buyOfferList = stockBuyOffersMap.get(symbolStockMap.get(request.getSymbol()));
        	if(buyOfferList != null) {
	        	Collections.sort(buyOfferList, Comparator.comparingDouble(BuyOffer::getStockPrice).reversed());
	        	List<BuyOffer> highestOffers = buyOfferList.subList(0, Math.min(request.getNumberOfOffers(), buyOfferList.size()));
	            for (BuyOffer buyOffer : highestOffers) {
	            	responseObserver.onNext(buyOffer);
	            }
        	}
        }
        
        
        @Override
        public void getSellOffers(AskRequest request, StreamObserver<SellOffer> responseObserver) {
        	CopyOnWriteArrayList<SellOffer> sellOfferList = stockSellOffersMap.get(symbolStockMap.get(request.getSymbol()));
        	if(sellOfferList != null) {
	        	Collections.sort(sellOfferList, Comparator.comparingDouble(SellOffer::getStockPrice));
	        	List<SellOffer> highestOffers = sellOfferList.subList(0, Math.min(request.getNumberOfOffers(), sellOfferList.size()));
	            for (SellOffer sellOffer : highestOffers) {
	            	responseObserver.onNext(sellOffer);
	            }
        	}
        }
        
        @Override
        public void addBuyOffer(BuyOffer request, StreamObserver<Empty> responseObserver) {
        	Stock stock = symbolStockMap.get(request.getSymbol());
            CopyOnWriteArrayList<BuyOffer> buyOffers = stockBuyOffersMap.get(stock);

            if (buyOffers == null) {
                buyOffers = new CopyOnWriteArrayList<>();
                stockBuyOffersMap.put(stock, buyOffers);
            }

            buyOffers.add(request);

            stockBuyOffersMap.put(stock, buyOffers);
        }
        
        @Override
        public void addSellOffer(SellOffer request, StreamObserver<Empty> responseObserver) {
        	Stock stock = symbolStockMap.get(request.getSymbol());
            CopyOnWriteArrayList<SellOffer> sellOffers = stockSellOffersMap.get(stock);

            if (sellOffers == null) {
            	sellOffers = new CopyOnWriteArrayList<>();
                stockSellOffersMap.put(stock, sellOffers);
            }

            sellOffers.add(request);

            stockSellOffersMap.put(stock, sellOffers);
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
