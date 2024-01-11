package rs.raf.pds.v5.z2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;

import rs.raf.pds.v5.z2.gRPC.AskBidRequest;
import rs.raf.pds.v5.z2.gRPC.ClientId;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Offer;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;
import rs.raf.pds.v5.z2.gRPC.TransactionNotification;

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

        
        StreamObserver<TransactionNotification> transactionNotificationObserver = new StreamObserver<TransactionNotification>() {
            @Override
            public void onNext(TransactionNotification transactionNotification) {
                System.out.println("Transaction Notification:");
                System.out.println("Symbol: " + transactionNotification.getSymbol());
                System.out.println("Price: " + transactionNotification.getPrice());
                System.out.println("Number of Shares: " + transactionNotification.getNumberOfShares());
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error occurred in transaction notification: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                // Handle completion if needed
            }
        };
        
        StocksServiceGrpc.StocksServiceBlockingStub blockingStub = StocksServiceGrpc.newBlockingStub(channel);
        StocksServiceGrpc.StocksServiceStub asyncStub = StocksServiceGrpc.newStub(channel);
        Empty emptyRequest = Empty.newBuilder().build();
        String clientId = blockingStub.getUniqueId(emptyRequest).getClientId();
        Iterator<Stock> stocks = blockingStub.getAllStocks(emptyRequest);
        while (stocks.hasNext()) {
            Stock s = stocks.next();
            stockMap.put(s.getSymbol(), s);
            ispisStock(s);
        }

        StreamObserver<Stock> responseObserverSubscribe = new StreamObserver<Stock>() {
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
        
        StreamObserver<Offer> responseObserverOffers = new StreamObserver<Offer>() {
            @Override
            public void onNext(Offer offer) {
            	if(offer.getBuy()) {
                	ispisBuyOffer(offer);
            	}
            	else {
            		ispisSellOffer(offer);
            	}
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error occurred: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {

            }
        };
        
        StreamObserver<Empty> responseObserverEmpty = new StreamObserver<Empty>() {
            @Override
            public void onNext(Empty empty) {
            	System.err.println("empty");
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

        SubscribeUpit subscriptionRequest = SubscribeUpit.newBuilder().addAllSymbols(symbols).build();

        // Subscribe to the stocks
        asyncStub.subscribeStocks(subscriptionRequest, responseObserverSubscribe);
        asyncStub.subToTransactions(ClientId.newBuilder().setClientId(clientId).build(), transactionNotificationObserver);
        String command;
        while (true) {
            System.out.print("Enter command (/exit to exit): ");
            command = reader.readLine().trim();
            
            if ("/exit".equalsIgnoreCase(command)) {
                break;
            } else if (command.startsWith("/buyOffer")) {
            	String[] parts = command.split("\\s+", 4);
            	if (parts.length == 4) {
		            String symbol = parts[1].trim();
		            double stockPrice = Double.parseDouble(parts[2].trim());
		            int numberOfOffers = Integer.parseInt(parts[3].trim());
	            	asyncStub.addOffer(Offer.newBuilder()
	            			.setSymbol(symbol)
	            			.setStockPrice(stockPrice)
	            			.setNumberOfOffers(numberOfOffers)
	            			.setBuy(true)
	            			.setClientId(clientId).build()
	            			, transactionNotificationObserver);
		        } else {
		        	System.out.println("Invalid buyOffer format, the expected format is /buyOffer symbol stockPrice numberOfOffers");
		        }
            } else if (command.startsWith("/sellOffer")) {
            	String[] parts = command.split("\\s+", 4);
            	if (parts.length == 4) {
		            String symbol = parts[1].trim();
		            double stockPrice = Double.parseDouble(parts[2].trim());
		            int numberOfOffers = Integer.parseInt(parts[3].trim());
	            	asyncStub.addOffer(Offer.newBuilder()
	            			.setSymbol(symbol)
	            			.setStockPrice(stockPrice)
	            			.setNumberOfOffers(numberOfOffers)
	            			.setBuy(false)
	            			.setClientId(clientId).build()
	            			, transactionNotificationObserver);
		        } else {
		        	System.out.println("Invalid sellOffer format, the expected format is /sellOffer symbol stockPrice numberOfOffers");
		        }
            } else if (command.startsWith("/getBuyOffers")) {
            	String[] parts = command.split("\\s+", 3);
            	if (parts.length == 3) {
		            String symbol = parts[1].trim();
		            int numberOfOffers = Integer.parseInt(parts[2].trim());
	            	asyncStub.getOffers(AskBidRequest.newBuilder()
	            			.setSymbol(symbol)
	            			.setNumberOfOffers(numberOfOffers)
	            			.setAsk(false).build(), responseObserverOffers);
		        } else {
		        	System.out.println("Invalid getBuyOffers format, the expected format is /getBuyOffers symbol numberOfOffers");
		        }
            } else if (command.startsWith("/getSellOffers")) {
            	String[] parts = command.split("\\s+", 3);
            	if (parts.length == 3) {
		            String symbol = parts[1].trim();
		            int numberOfOffers = Integer.parseInt(parts[2].trim());
	            	asyncStub.getOffers(AskBidRequest.newBuilder()
	            			.setSymbol(symbol)
	            			.setNumberOfOffers(numberOfOffers)
	            			.setAsk(true).build(), responseObserverOffers);
		        } else {
		        	System.out.println("Invalid getSellOffers format, the expected format is /getBuyOffers symbol numberOfOffers");
		        }
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        channel.shutdown();
        reader.close();
    }

    private static void ispisStock(Stock stock) {
        System.out.println(stock.getSymbol() + " " +
                String.format("%.2f", stock.getStartPrice()) + " " +
                String.format("%.2f", stock.getChangeInPrice()));
    }
    
    private static void ispisBuyOffer(Offer buyOffer) {
        System.out.println(buyOffer.getSymbol() + " " +
        					"Nr. Offers: " + buyOffer.getNumberOfOffers() + " " +
                String.format("%.2f", buyOffer.getStockPrice()));
    }
    
    private static void ispisSellOffer(Offer sellOffer) {
        System.out.println(sellOffer.getSymbol() + " " +
        					"Nr. Offers: " + sellOffer.getNumberOfOffers() + " " +
                String.format("%.2f", sellOffer.getStockPrice()));
    }
    
    private static void ispisStockUpdate(Stock stock) {
        System.out.print(stock.getSymbol() + " " +
                String.format("%.2f", stock.getStartPrice()) + " ");

        double changeInPrice = stock.getChangeInPrice();
        if (changeInPrice > 0) {
            System.out.print(Ansi.ansi().fgGreen().a("+" + String.format("%.2f", changeInPrice) + "↑ \u2191").reset());
        } else if (changeInPrice < 0) {
            System.out.print(Ansi.ansi().fgRed().a(String.format("%.2f", changeInPrice) + "↓ \u2193").reset());
        } else {
            System.out.print(String.format("%.2f", changeInPrice));
        }
    }
}
