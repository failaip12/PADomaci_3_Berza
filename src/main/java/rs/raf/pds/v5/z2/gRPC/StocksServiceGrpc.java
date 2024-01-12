package rs.raf.pds.v5.z2.gRPC;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: stocks_service.proto")
public final class StocksServiceGrpc {

  private StocksServiceGrpc() {}

  public static final String SERVICE_NAME = "StocksService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetUniqueIdMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty,
      rs.raf.pds.v5.z2.gRPC.ClientId> METHOD_GET_UNIQUE_ID = getGetUniqueIdMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty,
      rs.raf.pds.v5.z2.gRPC.ClientId> getGetUniqueIdMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty,
      rs.raf.pds.v5.z2.gRPC.ClientId> getGetUniqueIdMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty, rs.raf.pds.v5.z2.gRPC.ClientId> getGetUniqueIdMethod;
    if ((getGetUniqueIdMethod = StocksServiceGrpc.getGetUniqueIdMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getGetUniqueIdMethod = StocksServiceGrpc.getGetUniqueIdMethod) == null) {
          StocksServiceGrpc.getGetUniqueIdMethod = getGetUniqueIdMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.Empty, rs.raf.pds.v5.z2.gRPC.ClientId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "GetUniqueId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.ClientId.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("GetUniqueId"))
                  .build();
          }
        }
     }
     return getGetUniqueIdMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetStockMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest,
      rs.raf.pds.v5.z2.gRPC.Stock> METHOD_GET_STOCK = getGetStockMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest,
      rs.raf.pds.v5.z2.gRPC.Stock> getGetStockMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest,
      rs.raf.pds.v5.z2.gRPC.Stock> getGetStockMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.StockRequest, rs.raf.pds.v5.z2.gRPC.Stock> getGetStockMethod;
    if ((getGetStockMethod = StocksServiceGrpc.getGetStockMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getGetStockMethod = StocksServiceGrpc.getGetStockMethod) == null) {
          StocksServiceGrpc.getGetStockMethod = getGetStockMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.StockRequest, rs.raf.pds.v5.z2.gRPC.Stock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "GetStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.StockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Stock.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("GetStock"))
                  .build();
          }
        }
     }
     return getGetStockMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllStocksMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty,
      rs.raf.pds.v5.z2.gRPC.Stock> METHOD_GET_ALL_STOCKS = getGetAllStocksMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty,
      rs.raf.pds.v5.z2.gRPC.Stock> getGetAllStocksMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty,
      rs.raf.pds.v5.z2.gRPC.Stock> getGetAllStocksMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Empty, rs.raf.pds.v5.z2.gRPC.Stock> getGetAllStocksMethod;
    if ((getGetAllStocksMethod = StocksServiceGrpc.getGetAllStocksMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getGetAllStocksMethod = StocksServiceGrpc.getGetAllStocksMethod) == null) {
          StocksServiceGrpc.getGetAllStocksMethod = getGetAllStocksMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.Empty, rs.raf.pds.v5.z2.gRPC.Stock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "GetAllStocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Stock.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("GetAllStocks"))
                  .build();
          }
        }
     }
     return getGetAllStocksMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubscribeStocksMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SubscribeUpit,
      rs.raf.pds.v5.z2.gRPC.Stock> METHOD_SUBSCRIBE_STOCKS = getSubscribeStocksMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SubscribeUpit,
      rs.raf.pds.v5.z2.gRPC.Stock> getSubscribeStocksMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SubscribeUpit,
      rs.raf.pds.v5.z2.gRPC.Stock> getSubscribeStocksMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SubscribeUpit, rs.raf.pds.v5.z2.gRPC.Stock> getSubscribeStocksMethod;
    if ((getSubscribeStocksMethod = StocksServiceGrpc.getSubscribeStocksMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getSubscribeStocksMethod = StocksServiceGrpc.getSubscribeStocksMethod) == null) {
          StocksServiceGrpc.getSubscribeStocksMethod = getSubscribeStocksMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.SubscribeUpit, rs.raf.pds.v5.z2.gRPC.Stock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "SubscribeStocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SubscribeUpit.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Stock.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("SubscribeStocks"))
                  .build();
          }
        }
     }
     return getSubscribeStocksMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOffersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskBidRequest,
      rs.raf.pds.v5.z2.gRPC.Offer> METHOD_GET_OFFERS = getGetOffersMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskBidRequest,
      rs.raf.pds.v5.z2.gRPC.Offer> getGetOffersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskBidRequest,
      rs.raf.pds.v5.z2.gRPC.Offer> getGetOffersMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskBidRequest, rs.raf.pds.v5.z2.gRPC.Offer> getGetOffersMethod;
    if ((getGetOffersMethod = StocksServiceGrpc.getGetOffersMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getGetOffersMethod = StocksServiceGrpc.getGetOffersMethod) == null) {
          StocksServiceGrpc.getGetOffersMethod = getGetOffersMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.AskBidRequest, rs.raf.pds.v5.z2.gRPC.Offer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "GetOffers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.AskBidRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Offer.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("GetOffers"))
                  .build();
          }
        }
     }
     return getGetOffersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddOfferMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Offer,
      rs.raf.pds.v5.z2.gRPC.AddOfferResult> METHOD_ADD_OFFER = getAddOfferMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Offer,
      rs.raf.pds.v5.z2.gRPC.AddOfferResult> getAddOfferMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Offer,
      rs.raf.pds.v5.z2.gRPC.AddOfferResult> getAddOfferMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.Offer, rs.raf.pds.v5.z2.gRPC.AddOfferResult> getAddOfferMethod;
    if ((getAddOfferMethod = StocksServiceGrpc.getAddOfferMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getAddOfferMethod = StocksServiceGrpc.getAddOfferMethod) == null) {
          StocksServiceGrpc.getAddOfferMethod = getAddOfferMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.Offer, rs.raf.pds.v5.z2.gRPC.AddOfferResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "AddOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Offer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.AddOfferResult.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("AddOffer"))
                  .build();
          }
        }
     }
     return getAddOfferMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSubToTransactionsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.ClientId,
      rs.raf.pds.v5.z2.gRPC.TransactionNotification> METHOD_SUB_TO_TRANSACTIONS = getSubToTransactionsMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.ClientId,
      rs.raf.pds.v5.z2.gRPC.TransactionNotification> getSubToTransactionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.ClientId,
      rs.raf.pds.v5.z2.gRPC.TransactionNotification> getSubToTransactionsMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.ClientId, rs.raf.pds.v5.z2.gRPC.TransactionNotification> getSubToTransactionsMethod;
    if ((getSubToTransactionsMethod = StocksServiceGrpc.getSubToTransactionsMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getSubToTransactionsMethod = StocksServiceGrpc.getSubToTransactionsMethod) == null) {
          StocksServiceGrpc.getSubToTransactionsMethod = getSubToTransactionsMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.ClientId, rs.raf.pds.v5.z2.gRPC.TransactionNotification>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "SubToTransactions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.ClientId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.TransactionNotification.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("SubToTransactions"))
                  .build();
          }
        }
     }
     return getSubToTransactionsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTransactionHistoryMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.DateRequest,
      rs.raf.pds.v5.z2.gRPC.TransactionHistory> METHOD_GET_TRANSACTION_HISTORY = getGetTransactionHistoryMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.DateRequest,
      rs.raf.pds.v5.z2.gRPC.TransactionHistory> getGetTransactionHistoryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.DateRequest,
      rs.raf.pds.v5.z2.gRPC.TransactionHistory> getGetTransactionHistoryMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.DateRequest, rs.raf.pds.v5.z2.gRPC.TransactionHistory> getGetTransactionHistoryMethod;
    if ((getGetTransactionHistoryMethod = StocksServiceGrpc.getGetTransactionHistoryMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getGetTransactionHistoryMethod = StocksServiceGrpc.getGetTransactionHistoryMethod) == null) {
          StocksServiceGrpc.getGetTransactionHistoryMethod = getGetTransactionHistoryMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.DateRequest, rs.raf.pds.v5.z2.gRPC.TransactionHistory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "GetTransactionHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.DateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.TransactionHistory.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("GetTransactionHistory"))
                  .build();
          }
        }
     }
     return getGetTransactionHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StocksServiceStub newStub(io.grpc.Channel channel) {
    return new StocksServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StocksServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StocksServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StocksServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StocksServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StocksServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUniqueId(rs.raf.pds.v5.z2.gRPC.Empty request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.ClientId> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUniqueIdMethod(), responseObserver);
    }

    /**
     */
    public void getStock(rs.raf.pds.v5.z2.gRPC.StockRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStockMethod(), responseObserver);
    }

    /**
     */
    public void getAllStocks(rs.raf.pds.v5.z2.gRPC.Empty request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllStocksMethod(), responseObserver);
    }

    /**
     */
    public void subscribeStocks(rs.raf.pds.v5.z2.gRPC.SubscribeUpit request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeStocksMethod(), responseObserver);
    }

    /**
     */
    public void getOffers(rs.raf.pds.v5.z2.gRPC.AskBidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Offer> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOffersMethod(), responseObserver);
    }

    /**
     */
    public void addOffer(rs.raf.pds.v5.z2.gRPC.Offer request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.AddOfferResult> responseObserver) {
      asyncUnimplementedUnaryCall(getAddOfferMethod(), responseObserver);
    }

    /**
     */
    public void subToTransactions(rs.raf.pds.v5.z2.gRPC.ClientId request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TransactionNotification> responseObserver) {
      asyncUnimplementedUnaryCall(getSubToTransactionsMethod(), responseObserver);
    }

    /**
     */
    public void getTransactionHistory(rs.raf.pds.v5.z2.gRPC.DateRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TransactionHistory> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTransactionHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUniqueIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.Empty,
                rs.raf.pds.v5.z2.gRPC.ClientId>(
                  this, METHODID_GET_UNIQUE_ID)))
          .addMethod(
            getGetStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.StockRequest,
                rs.raf.pds.v5.z2.gRPC.Stock>(
                  this, METHODID_GET_STOCK)))
          .addMethod(
            getGetAllStocksMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.Empty,
                rs.raf.pds.v5.z2.gRPC.Stock>(
                  this, METHODID_GET_ALL_STOCKS)))
          .addMethod(
            getSubscribeStocksMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.SubscribeUpit,
                rs.raf.pds.v5.z2.gRPC.Stock>(
                  this, METHODID_SUBSCRIBE_STOCKS)))
          .addMethod(
            getGetOffersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.AskBidRequest,
                rs.raf.pds.v5.z2.gRPC.Offer>(
                  this, METHODID_GET_OFFERS)))
          .addMethod(
            getAddOfferMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.Offer,
                rs.raf.pds.v5.z2.gRPC.AddOfferResult>(
                  this, METHODID_ADD_OFFER)))
          .addMethod(
            getSubToTransactionsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.ClientId,
                rs.raf.pds.v5.z2.gRPC.TransactionNotification>(
                  this, METHODID_SUB_TO_TRANSACTIONS)))
          .addMethod(
            getGetTransactionHistoryMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.DateRequest,
                rs.raf.pds.v5.z2.gRPC.TransactionHistory>(
                  this, METHODID_GET_TRANSACTION_HISTORY)))
          .build();
    }
  }

  /**
   */
  public static final class StocksServiceStub extends io.grpc.stub.AbstractStub<StocksServiceStub> {
    private StocksServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StocksServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StocksServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StocksServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUniqueId(rs.raf.pds.v5.z2.gRPC.Empty request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.ClientId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUniqueIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStock(rs.raf.pds.v5.z2.gRPC.StockRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllStocks(rs.raf.pds.v5.z2.gRPC.Empty request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllStocksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribeStocks(rs.raf.pds.v5.z2.gRPC.SubscribeUpit request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeStocksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOffers(rs.raf.pds.v5.z2.gRPC.AskBidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Offer> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetOffersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addOffer(rs.raf.pds.v5.z2.gRPC.Offer request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.AddOfferResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subToTransactions(rs.raf.pds.v5.z2.gRPC.ClientId request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TransactionNotification> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubToTransactionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTransactionHistory(rs.raf.pds.v5.z2.gRPC.DateRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TransactionHistory> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetTransactionHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StocksServiceBlockingStub extends io.grpc.stub.AbstractStub<StocksServiceBlockingStub> {
    private StocksServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StocksServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StocksServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StocksServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.ClientId getUniqueId(rs.raf.pds.v5.z2.gRPC.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetUniqueIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.Stock getStock(rs.raf.pds.v5.z2.gRPC.StockRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStockMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.Stock> getAllStocks(
        rs.raf.pds.v5.z2.gRPC.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllStocksMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.Stock> subscribeStocks(
        rs.raf.pds.v5.z2.gRPC.SubscribeUpit request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeStocksMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.Offer> getOffers(
        rs.raf.pds.v5.z2.gRPC.AskBidRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetOffersMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.AddOfferResult addOffer(rs.raf.pds.v5.z2.gRPC.Offer request) {
      return blockingUnaryCall(
          getChannel(), getAddOfferMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.TransactionNotification> subToTransactions(
        rs.raf.pds.v5.z2.gRPC.ClientId request) {
      return blockingServerStreamingCall(
          getChannel(), getSubToTransactionsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.TransactionHistory> getTransactionHistory(
        rs.raf.pds.v5.z2.gRPC.DateRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetTransactionHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StocksServiceFutureStub extends io.grpc.stub.AbstractStub<StocksServiceFutureStub> {
    private StocksServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StocksServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StocksServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StocksServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.ClientId> getUniqueId(
        rs.raf.pds.v5.z2.gRPC.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUniqueIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.Stock> getStock(
        rs.raf.pds.v5.z2.gRPC.StockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.AddOfferResult> addOffer(
        rs.raf.pds.v5.z2.gRPC.Offer request) {
      return futureUnaryCall(
          getChannel().newCall(getAddOfferMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_UNIQUE_ID = 0;
  private static final int METHODID_GET_STOCK = 1;
  private static final int METHODID_GET_ALL_STOCKS = 2;
  private static final int METHODID_SUBSCRIBE_STOCKS = 3;
  private static final int METHODID_GET_OFFERS = 4;
  private static final int METHODID_ADD_OFFER = 5;
  private static final int METHODID_SUB_TO_TRANSACTIONS = 6;
  private static final int METHODID_GET_TRANSACTION_HISTORY = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StocksServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StocksServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_UNIQUE_ID:
          serviceImpl.getUniqueId((rs.raf.pds.v5.z2.gRPC.Empty) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.ClientId>) responseObserver);
          break;
        case METHODID_GET_STOCK:
          serviceImpl.getStock((rs.raf.pds.v5.z2.gRPC.StockRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock>) responseObserver);
          break;
        case METHODID_GET_ALL_STOCKS:
          serviceImpl.getAllStocks((rs.raf.pds.v5.z2.gRPC.Empty) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_STOCKS:
          serviceImpl.subscribeStocks((rs.raf.pds.v5.z2.gRPC.SubscribeUpit) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Stock>) responseObserver);
          break;
        case METHODID_GET_OFFERS:
          serviceImpl.getOffers((rs.raf.pds.v5.z2.gRPC.AskBidRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Offer>) responseObserver);
          break;
        case METHODID_ADD_OFFER:
          serviceImpl.addOffer((rs.raf.pds.v5.z2.gRPC.Offer) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.AddOfferResult>) responseObserver);
          break;
        case METHODID_SUB_TO_TRANSACTIONS:
          serviceImpl.subToTransactions((rs.raf.pds.v5.z2.gRPC.ClientId) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TransactionNotification>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION_HISTORY:
          serviceImpl.getTransactionHistory((rs.raf.pds.v5.z2.gRPC.DateRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.TransactionHistory>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StocksServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StocksServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StocksService");
    }
  }

  private static final class StocksServiceFileDescriptorSupplier
      extends StocksServiceBaseDescriptorSupplier {
    StocksServiceFileDescriptorSupplier() {}
  }

  private static final class StocksServiceMethodDescriptorSupplier
      extends StocksServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StocksServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StocksServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StocksServiceFileDescriptorSupplier())
              .addMethod(getGetUniqueIdMethod())
              .addMethod(getGetStockMethod())
              .addMethod(getGetAllStocksMethod())
              .addMethod(getSubscribeStocksMethod())
              .addMethod(getGetOffersMethod())
              .addMethod(getAddOfferMethod())
              .addMethod(getSubToTransactionsMethod())
              .addMethod(getGetTransactionHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
