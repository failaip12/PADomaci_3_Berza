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
  @java.lang.Deprecated // Use {@link #getGetBuyOffersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOffer> METHOD_GET_BUY_OFFERS = getGetBuyOffersMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOffer> getGetBuyOffersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest,
      rs.raf.pds.v5.z2.gRPC.BuyOffer> getGetBuyOffersMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BidRequest, rs.raf.pds.v5.z2.gRPC.BuyOffer> getGetBuyOffersMethod;
    if ((getGetBuyOffersMethod = StocksServiceGrpc.getGetBuyOffersMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getGetBuyOffersMethod = StocksServiceGrpc.getGetBuyOffersMethod) == null) {
          StocksServiceGrpc.getGetBuyOffersMethod = getGetBuyOffersMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.BidRequest, rs.raf.pds.v5.z2.gRPC.BuyOffer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "GetBuyOffers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BidRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BuyOffer.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("GetBuyOffers"))
                  .build();
          }
        }
     }
     return getGetBuyOffersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSellOffersMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.SellOffer> METHOD_GET_SELL_OFFERS = getGetSellOffersMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.SellOffer> getGetSellOffersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest,
      rs.raf.pds.v5.z2.gRPC.SellOffer> getGetSellOffersMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.AskRequest, rs.raf.pds.v5.z2.gRPC.SellOffer> getGetSellOffersMethod;
    if ((getGetSellOffersMethod = StocksServiceGrpc.getGetSellOffersMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getGetSellOffersMethod = StocksServiceGrpc.getGetSellOffersMethod) == null) {
          StocksServiceGrpc.getGetSellOffersMethod = getGetSellOffersMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.AskRequest, rs.raf.pds.v5.z2.gRPC.SellOffer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "GetSellOffers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.AskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SellOffer.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("GetSellOffers"))
                  .build();
          }
        }
     }
     return getGetSellOffersMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddBuyOfferMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyOffer,
      rs.raf.pds.v5.z2.gRPC.Empty> METHOD_ADD_BUY_OFFER = getAddBuyOfferMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyOffer,
      rs.raf.pds.v5.z2.gRPC.Empty> getAddBuyOfferMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyOffer,
      rs.raf.pds.v5.z2.gRPC.Empty> getAddBuyOfferMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.BuyOffer, rs.raf.pds.v5.z2.gRPC.Empty> getAddBuyOfferMethod;
    if ((getAddBuyOfferMethod = StocksServiceGrpc.getAddBuyOfferMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getAddBuyOfferMethod = StocksServiceGrpc.getAddBuyOfferMethod) == null) {
          StocksServiceGrpc.getAddBuyOfferMethod = getAddBuyOfferMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.BuyOffer, rs.raf.pds.v5.z2.gRPC.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "AddBuyOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.BuyOffer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("AddBuyOffer"))
                  .build();
          }
        }
     }
     return getAddBuyOfferMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddSellOfferMethod()} instead. 
  public static final io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellOffer,
      rs.raf.pds.v5.z2.gRPC.Empty> METHOD_ADD_SELL_OFFER = getAddSellOfferMethod();

  private static volatile io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellOffer,
      rs.raf.pds.v5.z2.gRPC.Empty> getAddSellOfferMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellOffer,
      rs.raf.pds.v5.z2.gRPC.Empty> getAddSellOfferMethod() {
    io.grpc.MethodDescriptor<rs.raf.pds.v5.z2.gRPC.SellOffer, rs.raf.pds.v5.z2.gRPC.Empty> getAddSellOfferMethod;
    if ((getAddSellOfferMethod = StocksServiceGrpc.getAddSellOfferMethod) == null) {
      synchronized (StocksServiceGrpc.class) {
        if ((getAddSellOfferMethod = StocksServiceGrpc.getAddSellOfferMethod) == null) {
          StocksServiceGrpc.getAddSellOfferMethod = getAddSellOfferMethod = 
              io.grpc.MethodDescriptor.<rs.raf.pds.v5.z2.gRPC.SellOffer, rs.raf.pds.v5.z2.gRPC.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StocksService", "AddSellOffer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.SellOffer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  rs.raf.pds.v5.z2.gRPC.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new StocksServiceMethodDescriptorSupplier("AddSellOffer"))
                  .build();
          }
        }
     }
     return getAddSellOfferMethod;
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
    public void getBuyOffers(rs.raf.pds.v5.z2.gRPC.BidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOffer> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBuyOffersMethod(), responseObserver);
    }

    /**
     */
    public void getSellOffers(rs.raf.pds.v5.z2.gRPC.AskRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOffer> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSellOffersMethod(), responseObserver);
    }

    /**
     */
    public void addBuyOffer(rs.raf.pds.v5.z2.gRPC.BuyOffer request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getAddBuyOfferMethod(), responseObserver);
    }

    /**
     */
    public void addSellOffer(rs.raf.pds.v5.z2.gRPC.SellOffer request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getAddSellOfferMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
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
            getGetBuyOffersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.BidRequest,
                rs.raf.pds.v5.z2.gRPC.BuyOffer>(
                  this, METHODID_GET_BUY_OFFERS)))
          .addMethod(
            getGetSellOffersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.AskRequest,
                rs.raf.pds.v5.z2.gRPC.SellOffer>(
                  this, METHODID_GET_SELL_OFFERS)))
          .addMethod(
            getAddBuyOfferMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.BuyOffer,
                rs.raf.pds.v5.z2.gRPC.Empty>(
                  this, METHODID_ADD_BUY_OFFER)))
          .addMethod(
            getAddSellOfferMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                rs.raf.pds.v5.z2.gRPC.SellOffer,
                rs.raf.pds.v5.z2.gRPC.Empty>(
                  this, METHODID_ADD_SELL_OFFER)))
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
    public void getBuyOffers(rs.raf.pds.v5.z2.gRPC.BidRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOffer> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetBuyOffersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSellOffers(rs.raf.pds.v5.z2.gRPC.AskRequest request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOffer> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetSellOffersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addBuyOffer(rs.raf.pds.v5.z2.gRPC.BuyOffer request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddBuyOfferMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addSellOffer(rs.raf.pds.v5.z2.gRPC.SellOffer request,
        io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddSellOfferMethod(), getCallOptions()), request, responseObserver);
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
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.BuyOffer> getBuyOffers(
        rs.raf.pds.v5.z2.gRPC.BidRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetBuyOffersMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<rs.raf.pds.v5.z2.gRPC.SellOffer> getSellOffers(
        rs.raf.pds.v5.z2.gRPC.AskRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetSellOffersMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.Empty addBuyOffer(rs.raf.pds.v5.z2.gRPC.BuyOffer request) {
      return blockingUnaryCall(
          getChannel(), getAddBuyOfferMethod(), getCallOptions(), request);
    }

    /**
     */
    public rs.raf.pds.v5.z2.gRPC.Empty addSellOffer(rs.raf.pds.v5.z2.gRPC.SellOffer request) {
      return blockingUnaryCall(
          getChannel(), getAddSellOfferMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.Stock> getStock(
        rs.raf.pds.v5.z2.gRPC.StockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStockMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.Empty> addBuyOffer(
        rs.raf.pds.v5.z2.gRPC.BuyOffer request) {
      return futureUnaryCall(
          getChannel().newCall(getAddBuyOfferMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<rs.raf.pds.v5.z2.gRPC.Empty> addSellOffer(
        rs.raf.pds.v5.z2.gRPC.SellOffer request) {
      return futureUnaryCall(
          getChannel().newCall(getAddSellOfferMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STOCK = 0;
  private static final int METHODID_GET_ALL_STOCKS = 1;
  private static final int METHODID_SUBSCRIBE_STOCKS = 2;
  private static final int METHODID_GET_BUY_OFFERS = 3;
  private static final int METHODID_GET_SELL_OFFERS = 4;
  private static final int METHODID_ADD_BUY_OFFER = 5;
  private static final int METHODID_ADD_SELL_OFFER = 6;

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
        case METHODID_GET_BUY_OFFERS:
          serviceImpl.getBuyOffers((rs.raf.pds.v5.z2.gRPC.BidRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.BuyOffer>) responseObserver);
          break;
        case METHODID_GET_SELL_OFFERS:
          serviceImpl.getSellOffers((rs.raf.pds.v5.z2.gRPC.AskRequest) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.SellOffer>) responseObserver);
          break;
        case METHODID_ADD_BUY_OFFER:
          serviceImpl.addBuyOffer((rs.raf.pds.v5.z2.gRPC.BuyOffer) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Empty>) responseObserver);
          break;
        case METHODID_ADD_SELL_OFFER:
          serviceImpl.addSellOffer((rs.raf.pds.v5.z2.gRPC.SellOffer) request,
              (io.grpc.stub.StreamObserver<rs.raf.pds.v5.z2.gRPC.Empty>) responseObserver);
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
              .addMethod(getGetStockMethod())
              .addMethod(getGetAllStocksMethod())
              .addMethod(getSubscribeStocksMethod())
              .addMethod(getGetBuyOffersMethod())
              .addMethod(getGetSellOffersMethod())
              .addMethod(getAddBuyOfferMethod())
              .addMethod(getAddSellOfferMethod())
              .build();
        }
      }
    }
    return result;
  }
}
