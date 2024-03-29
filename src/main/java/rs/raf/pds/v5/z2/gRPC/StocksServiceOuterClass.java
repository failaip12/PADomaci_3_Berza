// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stocks_service.proto

package rs.raf.pds.v5.z2.gRPC;

public final class StocksServiceOuterClass {
  private StocksServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Stock_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Stock_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SubscribeUpit_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SubscribeUpit_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StockRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StockRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TransactionHistoryRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TransactionHistoryRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AskBidRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AskBidRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Offer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Offer_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TransactionHistory_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TransactionHistory_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ClientId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ClientId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AddOfferResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AddOfferResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024stocks_service.proto\"i\n\005Stock\022\016\n\006symbo" +
      "l\030\001 \001(\t\022\023\n\013companyName\030\002 \001(\t\022\022\n\nstartPri" +
      "ce\030\003 \001(\001\022\025\n\rchangeInPrice\030\004 \001(\001\022\020\n\010dateU" +
      "nix\030\005 \001(\003\"2\n\rSubscribeUpit\022\017\n\007symbols\030\001 " +
      "\003(\t\022\020\n\010clientId\030\002 \001(\t\"\036\n\014StockRequest\022\016\n" +
      "\006symbol\030\001 \001(\t\"U\n\031TransactionHistoryReque" +
      "st\022\014\n\004year\030\001 \001(\005\022\r\n\005month\030\002 \001(\005\022\013\n\003day\030\003" +
      " \001(\005\022\016\n\006symbol\030\004 \001(\t\"D\n\rAskBidRequest\022\016\n" +
      "\006symbol\030\001 \001(\t\022\026\n\016numberOfOffers\030\002 \001(\005\022\013\n" +
      "\003ask\030\003 \001(\010\"b\n\005Offer\022\016\n\006symbol\030\001 \001(\t\022\022\n\ns" +
      "tockPrice\030\002 \001(\001\022\026\n\016numberOfOffers\030\003 \001(\005\022" +
      "\013\n\003buy\030\004 \001(\010\022\020\n\010clientId\030\005 \001(\t\"\214\001\n\022Trans" +
      "actionHistory\022\026\n\016clientIdSeller\030\001 \001(\t\022\025\n" +
      "\rclientIdBuyer\030\002 \001(\t\022\016\n\006symbol\030\003 \001(\t\022\r\n\005" +
      "price\030\004 \001(\001\022\026\n\016numberOfShares\030\005 \001(\005\022\020\n\010d" +
      "ateUnix\030\006 \001(\003\"\034\n\010ClientId\022\020\n\010clientId\030\001 " +
      "\001(\t\"\007\n\005Empty\"!\n\016AddOfferResult\022\017\n\007messag" +
      "e\030\001 \001(\t2\307\002\n\rStocksService\022\"\n\013GetUniqueId" +
      "\022\006.Empty\032\t.ClientId\"\000\022#\n\010GetStock\022\r.Stoc" +
      "kRequest\032\006.Stock\"\000\022\"\n\014GetAllStocks\022\006.Emp" +
      "ty\032\006.Stock\"\0000\001\022+\n\017SubscribeStocks\022\016.Subs" +
      "cribeUpit\032\006.Empty\"\000\022\'\n\tGetOffers\022\016.AskBi" +
      "dRequest\032\006.Offer\"\0000\001\022%\n\010AddOffer\022\006.Offer" +
      "\032\017.AddOfferResult\"\000\022L\n\025GetTransactionHis" +
      "tory\022\032.TransactionHistoryRequest\032\023.Trans" +
      "actionHistory\"\0000\001B\031\n\025rs.raf.pds.v5.z2.gR" +
      "PCP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Stock_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Stock_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Stock_descriptor,
        new java.lang.String[] { "Symbol", "CompanyName", "StartPrice", "ChangeInPrice", "DateUnix", });
    internal_static_SubscribeUpit_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_SubscribeUpit_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SubscribeUpit_descriptor,
        new java.lang.String[] { "Symbols", "ClientId", });
    internal_static_StockRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_StockRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StockRequest_descriptor,
        new java.lang.String[] { "Symbol", });
    internal_static_TransactionHistoryRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_TransactionHistoryRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TransactionHistoryRequest_descriptor,
        new java.lang.String[] { "Year", "Month", "Day", "Symbol", });
    internal_static_AskBidRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_AskBidRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AskBidRequest_descriptor,
        new java.lang.String[] { "Symbol", "NumberOfOffers", "Ask", });
    internal_static_Offer_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Offer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Offer_descriptor,
        new java.lang.String[] { "Symbol", "StockPrice", "NumberOfOffers", "Buy", "ClientId", });
    internal_static_TransactionHistory_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_TransactionHistory_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TransactionHistory_descriptor,
        new java.lang.String[] { "ClientIdSeller", "ClientIdBuyer", "Symbol", "Price", "NumberOfShares", "DateUnix", });
    internal_static_ClientId_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_ClientId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ClientId_descriptor,
        new java.lang.String[] { "ClientId", });
    internal_static_Empty_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_AddOfferResult_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_AddOfferResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AddOfferResult_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
