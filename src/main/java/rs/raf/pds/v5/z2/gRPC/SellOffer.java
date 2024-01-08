// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stocks_service.proto

package rs.raf.pds.v5.z2.gRPC;

/**
 * Protobuf type {@code SellOffer}
 */
public final class SellOffer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:SellOffer)
    SellOfferOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SellOffer.newBuilder() to construct.
  private SellOffer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SellOffer() {
    symbol_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SellOffer();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SellOffer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SellOffer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.pds.v5.z2.gRPC.SellOffer.class, rs.raf.pds.v5.z2.gRPC.SellOffer.Builder.class);
  }

  public static final int SYMBOL_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object symbol_ = "";
  /**
   * <code>string symbol = 1;</code>
   * @return The symbol.
   */
  @java.lang.Override
  public java.lang.String getSymbol() {
    java.lang.Object ref = symbol_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      symbol_ = s;
      return s;
    }
  }
  /**
   * <code>string symbol = 1;</code>
   * @return The bytes for symbol.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSymbolBytes() {
    java.lang.Object ref = symbol_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      symbol_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STOCKPRICE_FIELD_NUMBER = 2;
  private double stockPrice_ = 0D;
  /**
   * <code>double stockPrice = 2;</code>
   * @return The stockPrice.
   */
  @java.lang.Override
  public double getStockPrice() {
    return stockPrice_;
  }

  public static final int NUMBEROFOFFERS_FIELD_NUMBER = 3;
  private int numberOfOffers_ = 0;
  /**
   * <code>int32 numberOfOffers = 3;</code>
   * @return The numberOfOffers.
   */
  @java.lang.Override
  public int getNumberOfOffers() {
    return numberOfOffers_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(symbol_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, symbol_);
    }
    if (java.lang.Double.doubleToRawLongBits(stockPrice_) != 0) {
      output.writeDouble(2, stockPrice_);
    }
    if (numberOfOffers_ != 0) {
      output.writeInt32(3, numberOfOffers_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(symbol_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, symbol_);
    }
    if (java.lang.Double.doubleToRawLongBits(stockPrice_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, stockPrice_);
    }
    if (numberOfOffers_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, numberOfOffers_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof rs.raf.pds.v5.z2.gRPC.SellOffer)) {
      return super.equals(obj);
    }
    rs.raf.pds.v5.z2.gRPC.SellOffer other = (rs.raf.pds.v5.z2.gRPC.SellOffer) obj;

    if (!getSymbol()
        .equals(other.getSymbol())) return false;
    if (java.lang.Double.doubleToLongBits(getStockPrice())
        != java.lang.Double.doubleToLongBits(
            other.getStockPrice())) return false;
    if (getNumberOfOffers()
        != other.getNumberOfOffers()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SYMBOL_FIELD_NUMBER;
    hash = (53 * hash) + getSymbol().hashCode();
    hash = (37 * hash) + STOCKPRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getStockPrice()));
    hash = (37 * hash) + NUMBEROFOFFERS_FIELD_NUMBER;
    hash = (53 * hash) + getNumberOfOffers();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SellOffer parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(rs.raf.pds.v5.z2.gRPC.SellOffer prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code SellOffer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SellOffer)
      rs.raf.pds.v5.z2.gRPC.SellOfferOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SellOffer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SellOffer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.pds.v5.z2.gRPC.SellOffer.class, rs.raf.pds.v5.z2.gRPC.SellOffer.Builder.class);
    }

    // Construct using rs.raf.pds.v5.z2.gRPC.SellOffer.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      symbol_ = "";
      stockPrice_ = 0D;
      numberOfOffers_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SellOffer_descriptor;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SellOffer getDefaultInstanceForType() {
      return rs.raf.pds.v5.z2.gRPC.SellOffer.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SellOffer build() {
      rs.raf.pds.v5.z2.gRPC.SellOffer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SellOffer buildPartial() {
      rs.raf.pds.v5.z2.gRPC.SellOffer result = new rs.raf.pds.v5.z2.gRPC.SellOffer(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(rs.raf.pds.v5.z2.gRPC.SellOffer result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.symbol_ = symbol_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.stockPrice_ = stockPrice_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.numberOfOffers_ = numberOfOffers_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof rs.raf.pds.v5.z2.gRPC.SellOffer) {
        return mergeFrom((rs.raf.pds.v5.z2.gRPC.SellOffer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.pds.v5.z2.gRPC.SellOffer other) {
      if (other == rs.raf.pds.v5.z2.gRPC.SellOffer.getDefaultInstance()) return this;
      if (!other.getSymbol().isEmpty()) {
        symbol_ = other.symbol_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getStockPrice() != 0D) {
        setStockPrice(other.getStockPrice());
      }
      if (other.getNumberOfOffers() != 0) {
        setNumberOfOffers(other.getNumberOfOffers());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              symbol_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 17: {
              stockPrice_ = input.readDouble();
              bitField0_ |= 0x00000002;
              break;
            } // case 17
            case 24: {
              numberOfOffers_ = input.readInt32();
              bitField0_ |= 0x00000004;
              break;
            } // case 24
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object symbol_ = "";
    /**
     * <code>string symbol = 1;</code>
     * @return The symbol.
     */
    public java.lang.String getSymbol() {
      java.lang.Object ref = symbol_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        symbol_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string symbol = 1;</code>
     * @return The bytes for symbol.
     */
    public com.google.protobuf.ByteString
        getSymbolBytes() {
      java.lang.Object ref = symbol_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        symbol_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string symbol = 1;</code>
     * @param value The symbol to set.
     * @return This builder for chaining.
     */
    public Builder setSymbol(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      symbol_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string symbol = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSymbol() {
      symbol_ = getDefaultInstance().getSymbol();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string symbol = 1;</code>
     * @param value The bytes for symbol to set.
     * @return This builder for chaining.
     */
    public Builder setSymbolBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      symbol_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private double stockPrice_ ;
    /**
     * <code>double stockPrice = 2;</code>
     * @return The stockPrice.
     */
    @java.lang.Override
    public double getStockPrice() {
      return stockPrice_;
    }
    /**
     * <code>double stockPrice = 2;</code>
     * @param value The stockPrice to set.
     * @return This builder for chaining.
     */
    public Builder setStockPrice(double value) {

      stockPrice_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>double stockPrice = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearStockPrice() {
      bitField0_ = (bitField0_ & ~0x00000002);
      stockPrice_ = 0D;
      onChanged();
      return this;
    }

    private int numberOfOffers_ ;
    /**
     * <code>int32 numberOfOffers = 3;</code>
     * @return The numberOfOffers.
     */
    @java.lang.Override
    public int getNumberOfOffers() {
      return numberOfOffers_;
    }
    /**
     * <code>int32 numberOfOffers = 3;</code>
     * @param value The numberOfOffers to set.
     * @return This builder for chaining.
     */
    public Builder setNumberOfOffers(int value) {

      numberOfOffers_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>int32 numberOfOffers = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumberOfOffers() {
      bitField0_ = (bitField0_ & ~0x00000004);
      numberOfOffers_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:SellOffer)
  }

  // @@protoc_insertion_point(class_scope:SellOffer)
  private static final rs.raf.pds.v5.z2.gRPC.SellOffer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.pds.v5.z2.gRPC.SellOffer();
  }

  public static rs.raf.pds.v5.z2.gRPC.SellOffer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SellOffer>
      PARSER = new com.google.protobuf.AbstractParser<SellOffer>() {
    @java.lang.Override
    public SellOffer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<SellOffer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SellOffer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.pds.v5.z2.gRPC.SellOffer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

