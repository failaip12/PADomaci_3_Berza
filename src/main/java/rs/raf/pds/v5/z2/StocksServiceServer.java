package rs.raf.pds.v5.z2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rs.raf.pds.v5.z2.gRPC.Empty;
import rs.raf.pds.v5.z2.gRPC.Offer;
import rs.raf.pds.v5.z2.gRPC.Stock;
import rs.raf.pds.v5.z2.gRPC.AskBidRequest;
import rs.raf.pds.v5.z2.gRPC.ClientId;
import rs.raf.pds.v5.z2.gRPC.TransactionHistoryRequest;
import rs.raf.pds.v5.z2.gRPC.StocksServiceGrpc.StocksServiceImplBase;
import rs.raf.pds.v5.z2.gRPC.SubscribeUpit;
//import rs.raf.pds.v5.z2.gRPC.TransactionNotification;
import rs.raf.pds.v5.z2.gRPC.TransactionHistory;
import rs.raf.pds.v5.z2.gRPC.AddOfferResult;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StocksServiceServer {
    private static final String DATA_FILE_PATH = "transactionHistory.txt";
    private static final String BACKUP_FILE_PATH = "transactionHistoryBackup.txt";
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8090)
                .addService(new StocksServiceImpl())
                .build();
        server.start();
        server.awaitTermination();
    }
    static class StocksServiceImpl extends StocksServiceImplBase {

        private ConcurrentMap<Socket, String> socketIDMap = new ConcurrentHashMap<Socket, String>();
        private ConcurrentMap<String, Socket> idSocketMap = new ConcurrentHashMap<String, Socket>();
        private ConcurrentMap<Socket, ObjectOutputStream> socketWriterMap = new ConcurrentHashMap<Socket, ObjectOutputStream>();
        
        Thread tcpThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(9090)) {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("I DONT KAPIRAM");
                    handleTCPClient(clientSocket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        private void handleTCPClient(Socket clientSocket) {
            Thread clientHandlerThread = new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());

                    String clientId = reader.readLine();
                    if (clientId != null) {
                        synchronized (socketIDMap) {
                            socketIDMap.put(clientSocket, clientId);
                            idSocketMap.put(clientId, clientSocket);
                            socketWriterMap.put(clientSocket, writer);
                        }
                    }

                    while (true) {
                        try {
                            sendUpdates(writer, clientSocket);
                            Thread.sleep(4000);
                        } catch (IOException e) {
                            // Handle IOException, including SocketException
                            handleClientDisconnect(clientSocket);
                            break;
                        } catch (InterruptedException e) {
                            // Handle InterruptedException
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            clientHandlerThread.start();
        }
        
        private void handleClientDisconnect(Socket clientSocket) {
            try {
                System.out.println("Client disconnected: " + clientSocket);
                synchronized (socketIDMap) {
                    socketIDMap.remove(clientSocket);
                }
                
                clientSocket.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
        private ConcurrentMap<String, Stock> symbolStockMap = new ConcurrentHashMap<String, Stock>();
        private ConcurrentMap<String, CopyOnWriteArrayList<String>> subscriptions = new ConcurrentHashMap<String, CopyOnWriteArrayList<String>>();
        private ConcurrentMap<String, ConcurrentMap<String, Integer>> clientStockBalanceMap = new ConcurrentHashMap<String, ConcurrentMap<String, Integer>>();
        private ConcurrentMap<String, CopyOnWriteArrayList<Offer>> stockSymbolOffersMap = new ConcurrentHashMap<String, CopyOnWriteArrayList<Offer>>();
        //private ConcurrentMap<String, StreamObserver<TransactionNotification>> idTransObserverMap = new ConcurrentHashMap<String, StreamObserver<TransactionNotification>>();
        private ConcurrentMap<Instant, CopyOnWriteArrayList<TransactionHistory>> dateTransactionHistoryMap = new ConcurrentHashMap<Instant, CopyOnWriteArrayList<TransactionHistory>>();
        private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        protected StocksServiceImpl() {
            initUnos();

            tcpThread.start();
            executorService.scheduleAtFixedRate(this::saveTransactionHistory, 0, 1, TimeUnit.MINUTES);
            //executorService.scheduleAtFixedRate(this::sendUpdates, 0, 5, TimeUnit.SECONDS);
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
        /*
        @Override
        public void subToTransactions(ClientId request, StreamObserver<TransactionNotification> responseObserver) {
        	idTransObserverMap.put(request.getClientId(), responseObserver);
        }
        */
        @Override
        public void getAllStocks(Empty request, StreamObserver<Stock> responseObserver) {
            for (Stock stock : symbolStockMap.values()) {
                responseObserver.onNext(stock);
            }
            responseObserver.onCompleted();
        }
        
        @Override
        public void getTransactionHistory(TransactionHistoryRequest request, StreamObserver<TransactionHistory> responseObserver) {
        	Instant date = LocalDateTime.of(request.getYear(), request.getMonth(), request.getDay(), 23, 59, 59)
        	        .atZone(ZoneId.systemDefault())
        	        .toInstant()
        	        .truncatedTo(ChronoUnit.DAYS);
        	System.out.println(date);
            CopyOnWriteArrayList<TransactionHistory> history = dateTransactionHistoryMap.get(date);
            if (history != null) {
                for (TransactionHistory event : history) {
                    if (event.getSymbol().equals(request.getSymbol())) {
                        responseObserver.onNext(event);
                    }
                }
            }
            responseObserver.onCompleted();
        }
        
        @Override
        public void subscribeStocks(SubscribeUpit request, StreamObserver<Empty> responseObserver) {
        	CopyOnWriteArrayList<String> temp = new CopyOnWriteArrayList<String>();
            for (String symbol : request.getSymbolsList()) {
            	temp.add(symbol);
            }
        	subscriptions.put(request.getClientId(), temp);
        }
        
        @Override
        public void getOffers(AskBidRequest request, StreamObserver<Offer> responseObserver) {
            CopyOnWriteArrayList<Offer> offerList = stockSymbolOffersMap.get(request.getSymbol());
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
            ConcurrentMap<String, Integer> clientBalance = clientStockBalanceMap.get(request.getClientId());
            String requestSymbol = request.getSymbol();
            int currentStockBalance = clientBalance.getOrDefault(requestSymbol, 0);
            StringBuilder responseMessage = new StringBuilder();

            if (!request.getBuy() && currentStockBalance < request.getNumberOfOffers()) {
                responseObserver.onNext(AddOfferResult.newBuilder()
					 .setMessage("Insufficient stocks to sell. You have " + currentStockBalance + " " + requestSymbol + " stocks").build());
                responseObserver.onCompleted();
                return;
            }
        	CopyOnWriteArrayList<Offer> offersList = stockSymbolOffersMap.get(requestSymbol);
            if (offersList == null) {
            	offersList = new CopyOnWriteArrayList<>();
            	offersList.add(request);
            	stockSymbolOffersMap.put(requestSymbol, offersList);
                responseObserver.onNext(AddOfferResult.newBuilder()
   					 .setMessage("DONE").build());
	       		responseObserver.onCompleted();
                return;
            }
            
            CopyOnWriteArrayList<Offer> userOffers = stockSymbolOffersMap.values().stream()
                    .flatMap(List::stream)
                    .filter(offer -> offer.getClientId().equals(request.getClientId()) && offer.getSymbol().equals(requestSymbol))
                    .collect(Collectors.toCollection(CopyOnWriteArrayList::new));

            for(Offer offer:userOffers) {
            	if(request.getBuy() == offer.getBuy()) {
                	responseMessage.append("You already have an existing order for " + requestSymbol + " It will be replaced with your new order.");
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
                            .setSymbol(requestSymbol)
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
                        .setSymbol(requestSymbol)
                        .setNumberOfOffers(numberOfOffersRequest).build();
	            offersList.add(updatedRequest);
            }
            stockSymbolOffersMap.put(requestSymbol, offersList);
            
            clientBalance.put(requestSymbol, currentStockBalance);
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
        	/*
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
        	*/
            //StreamObserver<TransactionNotification> buyerObserver = idTransObserverMap.get(buyOffer.getClientId());
            //StreamObserver<TransactionNotification> sellerObserver = idTransObserverMap.get(sellOffer.getClientId());
        	
        	
        	TransactionNotification transactionNotificationSeller = new TransactionNotification(sellOffer.getSymbol(), sellOffer.getStockPrice(), test, false);
        	
            ObjectOutputStream writerSeller = socketWriterMap.get(idSocketMap.get(sellOffer.getClientId()));
        	try {
				writerSeller.writeObject(transactionNotificationSeller);
	        	writerSeller.flush();
	        	writerSeller.reset();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        	TransactionNotification transactionNotificationBuyer = new TransactionNotification(buyOffer.getSymbol(), buyOffer.getStockPrice(), test, true);
        	
            ObjectOutputStream writerBuyer = socketWriterMap.get(idSocketMap.get(buyOffer.getClientId()));
        	try {
        		writerBuyer.writeObject(transactionNotificationBuyer);
        		writerBuyer.flush();
        		writerBuyer.reset();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
            /*
            if (buyerObserver != null) {
            	buyerObserver.onNext(transactionNotificationBuyer);
            }
            if (sellerObserver != null) {
            	sellerObserver.onNext(transactionNotificationSeller);
            }
            */
            Instant currentTime = Instant.now();
        	TransactionHistory transactionHistory = TransactionHistory.newBuilder()
                    .setClientIdSeller(sellOffer.getClientId())
                    .setClientIdBuyer(buyOffer.getClientId())
                    .setSymbol(sellOffer.getSymbol())
                    .setPrice(sellOffer.getStockPrice())
                    .setNumberOfShares(test)
                    .setDateUnix(currentTime.toEpochMilli())
                    .build();
        	Instant transactionDate = truncateToDay(currentTime);

        	dateTransactionHistoryMap.computeIfAbsent(transactionDate, k -> new CopyOnWriteArrayList<>()).add(transactionHistory);
        }
        
        private Instant truncateToDay(Instant instant) {
            return instant.truncatedTo(ChronoUnit.DAYS);
        }
        
        private void saveTransactionHistory() {
            try {
                File existingFile = new File(DATA_FILE_PATH);
                File backupFile = new File(BACKUP_FILE_PATH);
                if (existingFile.exists()) {
                    copyFile(existingFile, backupFile);
                }
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(existingFile))) {
                    outputStream.writeObject(dateTransactionHistoryMap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        private void copyFile(File source, File destination) throws IOException {
            try (InputStream inputStream = new FileInputStream(source);
                 OutputStream outputStream = new FileOutputStream(destination)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
            }
        }
        
        private void sendUpdates(ObjectOutputStream writer, Socket clientSocket) throws IOException {
        	//System.out.println(clientStockBalanceMap);
        	//System.out.println(stockOffersMap);
        	//System.out.println(dateTransactionHistoryMap);
        	String clientId = socketIDMap.get(clientSocket);            	
        	List<String> symbols = subscriptions.get(clientId);
        	if(symbols!=null) {
            	Collections.sort(symbols);
            	List<StockTCP> a1 = new ArrayList<StockTCP>();
            	for (String symbol:symbols) {
            		Stock stock = symbolStockMap.get(symbol);
            		StockTCP s = new StockTCP(stock.getSymbol(), stock.getCompanyName(), stock.getStartPrice(), stock.getChangeInPrice(), stock.getDateUnix());
            		a1.add(s);
            	}
				writer.writeObject(a1);
                writer.flush();
                writer.reset();
            }
        }
    }
}
