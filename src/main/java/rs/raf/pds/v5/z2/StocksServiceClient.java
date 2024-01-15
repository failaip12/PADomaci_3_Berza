package rs.raf.pds.v5.z2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;

import rs.raf.pds.v5.z2.gRPC.AddOfferResult;
import rs.raf.pds.v5.z2.gRPC.AskBidRequest;
import rs.raf.pds.v5.z2.gRPC.ClientId;
import rs.raf.pds.v5.z2.gRPC.TransactionHistoryRequest;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Offer;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;
import rs.raf.pds.v5.z2.gRPC.TransactionHistory;
import rs.raf.pds.v5.z2.gRPC.TransactionNotification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.time.DateTimeException;
import java.time.LocalDateTime;
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
                if(transactionNotification.getBuy()) {
                	System.out.println("BUY: ");
                } else {
                	System.out.println("SELL: ");
                }
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
        
        StreamObserver<TransactionHistory> responseObserverTransactionHistory = new StreamObserver<TransactionHistory>() {
            @Override
            public void onNext(TransactionHistory history) {
            	System.out.println(history);
            }

            @Override
            public void onError(Throwable throwable) {
                System.err.println("Error occurred: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {

            }
        };
        
        StreamObserver<AddOfferResult> responseObserverAddOfferResult = new StreamObserver<AddOfferResult>() {
            @Override
            public void onNext(AddOfferResult result) {
            	System.err.println(result);
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

        SubscribeUpit subscriptionRequest = SubscribeUpit.newBuilder().addAllSymbols(symbols).setClientId(clientId).build();

        // Subscribe to the stocks
        asyncStub.subscribeStocks(subscriptionRequest, responseObserverEmpty);
        asyncStub.subToTransactions(ClientId.newBuilder().setClientId(clientId).build(), transactionNotificationObserver);
        String command;
        Runnable clientCode = () -> {
            try (Socket tcpSocket = new Socket("localhost", 9090);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(tcpSocket.getOutputStream()));
                 ) {
                writer.write(clientId);
                writer.newLine();
                writer.flush();
                ObjectInputStream inputStream = new ObjectInputStream(tcpSocket.getInputStream());
                while (true) {
                    Object obj = inputStream.readObject();
                    if (obj instanceof List<?>) {
                        List<?> stockArray = (List<?>) obj;
                        if (!stockArray.isEmpty() && stockArray.get(0) instanceof StockTCP) {
                            @SuppressWarnings("unchecked")
                            List<StockTCP> typedStockArray = (List<StockTCP>) stockArray;
                            ispisStockUpdate(typedStockArray);
                        }
                    }
                }
            } catch (EOFException e) {
                // Connection closed gracefully
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        };

        Thread clientThread = new Thread(clientCode);
        clientThread.start();


        while (true) {
            System.out.print("Enter command (/exit to exit): ");
            command = reader.readLine().trim();
            
            if ("/exit".equalsIgnoreCase(command)) {
                break;
            } else if (command.startsWith("/buyOffer")) {
            	String[] parts = command.split("\\s+", 4);
            	if (parts.length == 4) {
		            String symbol = parts[1].trim();
		            try {
			            int numberOfOffers = Integer.parseInt(parts[3].trim());
			            double stockPrice = Double.parseDouble(parts[2].trim());
		            	asyncStub.addOffer(Offer.newBuilder()
		            			.setSymbol(symbol)
		            			.setStockPrice(stockPrice)
		            			.setNumberOfOffers(numberOfOffers)
		            			.setBuy(true)
		            			.setClientId(clientId).build()
		            			, responseObserverAddOfferResult);
		            }
		            catch (NumberFormatException e) {
		            	System.out.println("numberOfOffers or stockPrice is an invalid number");
					}
		        } else {
		        	System.out.println("Invalid buyOffer format, the expected format is /buyOffer symbol stockPrice numberOfOffers");
		        }
            } else if (command.startsWith("/sellOffer")) {
            	String[] parts = command.split("\\s+", 4);
            	if (parts.length == 4) {
		            String symbol = parts[1].trim();
		            try {
			            double stockPrice = Double.parseDouble(parts[2].trim());
			            int numberOfOffers = Integer.parseInt(parts[3].trim());
		            	asyncStub.addOffer(Offer.newBuilder()
		            			.setSymbol(symbol)
		            			.setStockPrice(stockPrice)
		            			.setNumberOfOffers(numberOfOffers)
		            			.setBuy(false)
		            			.setClientId(clientId).build()
		            			, responseObserverAddOfferResult);
		            }
		            catch (NumberFormatException e) {
		            	System.out.println("numberOfOffers or stockPrice is an invalid number");
					}
		        } else {
		        	System.out.println("Invalid sellOffer format, the expected format is /sellOffer symbol stockPrice numberOfOffers");
		        }
            } else if (command.startsWith("/getBuyOffers")) {
            	String[] parts = command.split("\\s+", 3);
            	if (parts.length == 3) {
		            String symbol = parts[1].trim();
		            try {
			            int numberOfOffers = Integer.parseInt(parts[2].trim());
		            	asyncStub.getOffers(AskBidRequest.newBuilder()
		            			.setSymbol(symbol)
		            			.setNumberOfOffers(numberOfOffers)
		            			.setAsk(false).build(), responseObserverOffers);
		            }
		            catch (NumberFormatException e) {
		            	System.out.println("numberOfOffer is an invalid integer");
					}
		        } else {
		        	System.out.println("Invalid getBuyOffers format, the expected format is /getBuyOffers symbol numberOfOffers");
		        }
            } else if (command.startsWith("/getSellOffers")) {
            	String[] parts = command.split("\\s+", 3);
            	if (parts.length == 3) {
		            String symbol = parts[1].trim();
		            try {
			            int numberOfOffers = Integer.parseInt(parts[2].trim());
		            	asyncStub.getOffers(AskBidRequest.newBuilder()
		            			.setSymbol(symbol)
		            			.setNumberOfOffers(numberOfOffers)
		            			.setAsk(true).build(), responseObserverOffers);
		            }
		            catch (NumberFormatException e) {
		            	System.out.println("numberOfOffer is an invalid integer");
					}
		        }
            	else {
		        	System.out.println("Invalid getSellOffers format, the expected format is /getSellOffers symbol numberOfOffers");
		        }
            }
            else if (command.startsWith("/getTransactionHistory")) {
            	String[] parts = command.split("\\s+", 5);
            	if (parts.length == 5) {
                    try {
                    	String symbol = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());
                        int month = Integer.parseInt(parts[3].trim());
                        int day = Integer.parseInt(parts[4].trim());
                        try {
                        	LocalDateTime.of(year, month, day, 23, 59, 59);
                            asyncStub.getTransactionHistory(
                            		TransactionHistoryRequest.newBuilder()
                            				.setSymbol(symbol)
                                            .setYear(year)
                                            .setMonth(month)
                                            .setDay(day)
                                            .build(),
                                    responseObserverTransactionHistory
                            );
                        }
                        catch (DateTimeException e){
                        	System.out.println("Invalid date: Please provide a valid date.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input: Please provide valid integers for year, month, and day.");
                    }
		        }
            	else {
		        	System.out.println("Invalid getTransactionHistory format, the expected format is /getTransactionHistory symbol year month day");
		        }
            }
            else {
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
    private static void ispisStockUpdate(List<StockTCP> stocks) {
        // Move the cursor to the top-left corner
        //System.out.print(Ansi.ansi().cursor(1, 1));
    	System.out.print("\n");
        // Iterate through stocks to update the output map
        for (StockTCP stock : stocks) {
            String symbol = stock.symbol();
            StringBuilder outputBuilder = new StringBuilder();
            outputBuilder.append(symbol).append(" ")
                    .append(String.format("%.2f", stock.startPrice())).append(" ");

            double changeInPrice = stock.changeInPrice();
            if (changeInPrice > 0) {
                outputBuilder.append(Ansi.ansi().fgGreen().a("+" + String.format("%.2f", changeInPrice) + "↑ \u2191").reset());
            } else if (changeInPrice < 0) {
                outputBuilder.append(Ansi.ansi().fgRed().a(String.format("%.2f", changeInPrice) + "↓ \u2193").reset());
            } else {
                outputBuilder.append(String.format("%.2f", changeInPrice));
            }
            System.out.print(outputBuilder.toString());
            System.out.print("\n");
        }

        // Move the cursor back to the top-left corner after printing
        for (int i = 0; i < stocks.size() + 1; i++) {
            System.out.print(Ansi.ansi().cursorUpLine());
        }
    }


}
