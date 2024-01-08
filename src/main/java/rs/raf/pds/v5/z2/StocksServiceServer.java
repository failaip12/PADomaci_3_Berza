package rs.raf.pds.v5.z2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc.StocksServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        private Map<String, Stock> stockMap = new HashMap<>();
        private Map<String, List<StreamObserver<Stock>>> subscriptions = new HashMap<>();

        private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        protected StocksServiceImpl() {
            initUnos();

            // Simulate periodic updates
            executorService.scheduleAtFixedRate(this::sendUpdates, 0, 5, TimeUnit.SECONDS);
        }

        private void initUnos() {
            for (Stock s : InitialData.initStocks()) {
                stockMap.put(s.getSymbol(), s);
            }
        }
        
        @Override
        public void getAllStocks(Empty request, StreamObserver<Stock> responseObserver) {
            for (Stock stock : stockMap.values()) {
                responseObserver.onNext(stock);
            }
            responseObserver.onCompleted();
        }
        
        @Override
        public void subscribeStocks(SubscribeUpit request, StreamObserver<Stock> responseObserver) {
            for (String symbol : request.getSymbolsList()) {
                subscriptions.computeIfAbsent(symbol.trim(), k -> new ArrayList<>()).add(responseObserver);
            }
        }
        
        private void sendUpdates() {
            for (String symbol : subscriptions.keySet()) {
                Stock stock = stockMap.get(symbol);
                if (stock != null) {
                    List<StreamObserver<Stock>> observers = subscriptions.get(symbol);
                    for (StreamObserver<Stock> observer : observers) {
                        System.out.println(stock.getSymbol() + " " +
                                String.format("%.2f", stock.getStartPrice()) + " " +
                                String.format("%.2f", stock.getChangeInPrice()));
                        observer.onNext(stock);
                    }
                }
            }
        }
    }
}
