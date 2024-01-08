package rs.raf.pds.v5.z2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StocksServiceClient {

    private static final Map<String, Stock> stockMap = new HashMap<String, Stock>();
    private static final Map<String, Integer> stockPostionMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090)
                .usePlaintext()
                .build();

        StocksServiceGrpc.StocksServiceBlockingStub blockingStub = StocksServiceGrpc.newBlockingStub(channel);
        StocksServiceGrpc.StocksServiceStub asyncStub = StocksServiceGrpc.newStub(channel);
        Empty emptyRequest = Empty.newBuilder().build();

        Iterator<Stock> stocks = blockingStub.getAllStocks(emptyRequest);
        while (stocks.hasNext()) {
            Stock s = stocks.next();
            stockMap.put(s.getSymbol(), s);
            ispisStock(s);
        }

        // Create a stream observer to handle server responses
        StreamObserver<Stock> responseObserver = new StreamObserver<Stock>() {
            @Override
            public void onNext(Stock stock) {
            	ispisStockUpdate(stock);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error occurred: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {

            }
        };
        System.out.print("Enter company symbols to subscribe (comma-separated): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String symbolsInput;
        symbolsInput = reader.readLine();
        AnsiConsole.systemInstall();
        List<String> symbols = new ArrayList<String>();
        int temp = 0;
        for(String symbol : List.of(symbolsInput.split(","))) {
            if (stockMap.containsKey(symbol.trim())) {
            	symbols.add(symbol.trim());
            	stockPostionMap.put(symbol.trim(), temp);
            	temp++;
            }
        }

        // Create a new request for subscription
        SubscribeUpit subscriptionRequest = SubscribeUpit.newBuilder().addAllSymbols(symbols).build();

        // Subscribe to the stocks
        asyncStub.subscribeStocks(subscriptionRequest, responseObserver);

        // Keep the client running until the user decides to exit
        System.out.println("Press Enter to exit.");
        reader.readLine();

        channel.shutdown();
    }

    private static void ispisStock(Stock stock) {
        System.out.println(stock.getSymbol() + " " +
                String.format("%.2f", stock.getStartPrice()) + " " +
                String.format("%.2f", stock.getChangeInPrice()));
    }
    
    private static void ispisStockUpdate(Stock stock) {
        if (stockPostionMap.containsKey(stock.getSymbol())) {
            // Move the cursor up one line
            System.out.print(Ansi.ansi().cursorUp(1));

            System.out.print(stock.getSymbol() + " " +
                    String.format("%.2f", stock.getStartPrice()) + " ");

            double changeInPrice = stock.getChangeInPrice();
            if (changeInPrice > 0) {
                System.out.print(Ansi.ansi().fgGreen().a("+" + String.format("%.2f", changeInPrice) + " \u2191").reset());
            } else if (changeInPrice < 0) {
                System.out.print(Ansi.ansi().fgRed().a(String.format("%.2f", changeInPrice) + " \u2193").reset());
            } else {
                System.out.print(String.format("%.2f", changeInPrice));
            }

            // Move the cursor down one line
            System.out.println(Ansi.ansi().cursorDown(1));
        }
    }
}
