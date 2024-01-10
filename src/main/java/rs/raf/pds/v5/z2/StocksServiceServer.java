package rs.raf.pds.v5.z2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Offer;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.AskBidRequest;
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
        public void getOffers(AskBidRequest request, StreamObserver<Offer> responseObserver) {
            CopyOnWriteArrayList<Offer> offerList = stockOffersMap.get(symbolStockMap.get(request.getSymbol()));
            if (offerList != null) {
                List<Offer> offers = offerList.stream()
                        .filter(offer -> !request.getAsk())
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

            offers.add(request);

            stockOffersMap.put(stock, offers);
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
