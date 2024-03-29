// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stocks_service.proto

package rs.raf.pds.v5.z2.gRPC;

/**
 * <pre>
 *
 *message TransactionNotification {
 *string clientId = 1;
 *string symbol = 2;
 *double price = 3;
 *int32 numberOfShares = 4;
 *bool buy = 5;
 *}
 * </pre>
 *
 * Protobuf type {@code TransactionHistory}
 */
public final class TransactionHistory extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:TransactionHistory)
    TransactionHistoryOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TransactionHistory.newBuilder() to construct.
  private TransactionHistory(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TransactionHistory() {
    clientIdSeller_ = "";
    clientIdBuyer_ = "";
    symbol_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TransactionHistory();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_TransactionHistory_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_TransactionHistory_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.pds.v5.z2.gRPC.TransactionHistory.class, rs.raf.pds.v5.z2.gRPC.TransactionHistory.Builder.class);
  }

  public static final int CLIENTIDSELLER_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object clientIdSeller_ = "";
  /**
   * <code>string clientIdSeller = 1;</code>
   * @return The clientIdSeller.
   */
  @java.lang.Override
  public java.lang.String getClientIdSeller() {
    java.lang.Object ref = clientIdSeller_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      clientIdSeller_ = s;
      return s;
    }
  }
  /**
   * <code>string clientIdSeller = 1;</code>
   * @return The bytes for clientIdSeller.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getClientIdSellerBytes() {
    java.lang.Object ref = clientIdSeller_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      clientIdSeller_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CLIENTIDBUYER_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object clientIdBuyer_ = "";
  /**
   * <code>string clientIdBuyer = 2;</code>
   * @return The clientIdBuyer.
   */
  @java.lang.Override
  public java.lang.String getClientIdBuyer() {
    java.lang.Object ref = clientIdBuyer_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      clientIdBuyer_ = s;
      return s;
    }
  }
  /**
   * <code>string clientIdBuyer = 2;</code>
   * @return The bytes for clientIdBuyer.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getClientIdBuyerBytes() {
    java.lang.Object ref = clientIdBuyer_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      clientIdBuyer_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SYMBOL_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object symbol_ = "";
  /**
   * <code>string symbol = 3;</code>
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
   * <code>string symbol = 3;</code>
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

  public static final int PRICE_FIELD_NUMBER = 4;
  private double price_ = 0D;
  /**
   * <code>double price = 4;</code>
   * @return The price.
   */
  @java.lang.Override
  public double getPrice() {
    return price_;
  }

  public static final int NUMBEROFSHARES_FIELD_NUMBER = 5;
  private int numberOfShares_ = 0;
  /**
   * <code>int32 numberOfShares = 5;</code>
   * @return The numberOfShares.
   */
  @java.lang.Override
  public int getNumberOfShares() {
    return numberOfShares_;
  }

  public static final int DATEUNIX_FIELD_NUMBER = 6;
  private long dateUnix_ = 0L;
  /**
   * <code>int64 dateUnix = 6;</code>
   * @return The dateUnix.
   */
  @java.lang.Override
  public long getDateUnix() {
    return dateUnix_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clientIdSeller_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, clientIdSeller_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clientIdBuyer_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, clientIdBuyer_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(symbol_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, symbol_);
    }
    if (java.lang.Double.doubleToRawLongBits(price_) != 0) {
      output.writeDouble(4, price_);
    }
    if (numberOfShares_ != 0) {
      output.writeInt32(5, numberOfShares_);
    }
    if (dateUnix_ != 0L) {
      output.writeInt64(6, dateUnix_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clientIdSeller_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, clientIdSeller_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clientIdBuyer_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, clientIdBuyer_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(symbol_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, symbol_);
    }
    if (java.lang.Double.doubleToRawLongBits(price_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(4, price_);
    }
    if (numberOfShares_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, numberOfShares_);
    }
    if (dateUnix_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, dateUnix_);
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
    if (!(obj instanceof rs.raf.pds.v5.z2.gRPC.TransactionHistory)) {
      return super.equals(obj);
    }
    rs.raf.pds.v5.z2.gRPC.TransactionHistory other = (rs.raf.pds.v5.z2.gRPC.TransactionHistory) obj;

    if (!getClientIdSeller()
        .equals(other.getClientIdSeller())) return false;
    if (!getClientIdBuyer()
        .equals(other.getClientIdBuyer())) return false;
    if (!getSymbol()
        .equals(other.getSymbol())) return false;
    if (java.lang.Double.doubleToLongBits(getPrice())
        != java.lang.Double.doubleToLongBits(
            other.getPrice())) return false;
    if (getNumberOfShares()
        != other.getNumberOfShares()) return false;
    if (getDateUnix()
        != other.getDateUnix()) return false;
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
    hash = (37 * hash) + CLIENTIDSELLER_FIELD_NUMBER;
    hash = (53 * hash) + getClientIdSeller().hashCode();
    hash = (37 * hash) + CLIENTIDBUYER_FIELD_NUMBER;
    hash = (53 * hash) + getClientIdBuyer().hashCode();
    hash = (37 * hash) + SYMBOL_FIELD_NUMBER;
    hash = (53 * hash) + getSymbol().hashCode();
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPrice()));
    hash = (37 * hash) + NUMBEROFSHARES_FIELD_NUMBER;
    hash = (53 * hash) + getNumberOfShares();
    hash = (37 * hash) + DATEUNIX_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getDateUnix());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory parseFrom(
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
  public static Builder newBuilder(rs.raf.pds.v5.z2.gRPC.TransactionHistory prototype) {
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
   * <pre>
   *
   *message TransactionNotification {
   *string clientId = 1;
   *string symbol = 2;
   *double price = 3;
   *int32 numberOfShares = 4;
   *bool buy = 5;
   *}
   * </pre>
   *
   * Protobuf type {@code TransactionHistory}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:TransactionHistory)
      rs.raf.pds.v5.z2.gRPC.TransactionHistoryOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_TransactionHistory_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_TransactionHistory_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.pds.v5.z2.gRPC.TransactionHistory.class, rs.raf.pds.v5.z2.gRPC.TransactionHistory.Builder.class);
    }

    // Construct using rs.raf.pds.v5.z2.gRPC.TransactionHistory.newBuilder()
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
      clientIdSeller_ = "";
      clientIdBuyer_ = "";
      symbol_ = "";
      price_ = 0D;
      numberOfShares_ = 0;
      dateUnix_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_TransactionHistory_descriptor;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.TransactionHistory getDefaultInstanceForType() {
      return rs.raf.pds.v5.z2.gRPC.TransactionHistory.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.TransactionHistory build() {
      rs.raf.pds.v5.z2.gRPC.TransactionHistory result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.TransactionHistory buildPartial() {
      rs.raf.pds.v5.z2.gRPC.TransactionHistory result = new rs.raf.pds.v5.z2.gRPC.TransactionHistory(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(rs.raf.pds.v5.z2.gRPC.TransactionHistory result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.clientIdSeller_ = clientIdSeller_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.clientIdBuyer_ = clientIdBuyer_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.symbol_ = symbol_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.price_ = price_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.numberOfShares_ = numberOfShares_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.dateUnix_ = dateUnix_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof rs.raf.pds.v5.z2.gRPC.TransactionHistory) {
        return mergeFrom((rs.raf.pds.v5.z2.gRPC.TransactionHistory)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.pds.v5.z2.gRPC.TransactionHistory other) {
      if (other == rs.raf.pds.v5.z2.gRPC.TransactionHistory.getDefaultInstance()) return this;
      if (!other.getClientIdSeller().isEmpty()) {
        clientIdSeller_ = other.clientIdSeller_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getClientIdBuyer().isEmpty()) {
        clientIdBuyer_ = other.clientIdBuyer_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getSymbol().isEmpty()) {
        symbol_ = other.symbol_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.getPrice() != 0D) {
        setPrice(other.getPrice());
      }
      if (other.getNumberOfShares() != 0) {
        setNumberOfShares(other.getNumberOfShares());
      }
      if (other.getDateUnix() != 0L) {
        setDateUnix(other.getDateUnix());
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
              clientIdSeller_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              clientIdBuyer_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              symbol_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 33: {
              price_ = input.readDouble();
              bitField0_ |= 0x00000008;
              break;
            } // case 33
            case 40: {
              numberOfShares_ = input.readInt32();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            case 48: {
              dateUnix_ = input.readInt64();
              bitField0_ |= 0x00000020;
              break;
            } // case 48
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

    private java.lang.Object clientIdSeller_ = "";
    /**
     * <code>string clientIdSeller = 1;</code>
     * @return The clientIdSeller.
     */
    public java.lang.String getClientIdSeller() {
      java.lang.Object ref = clientIdSeller_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientIdSeller_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string clientIdSeller = 1;</code>
     * @return The bytes for clientIdSeller.
     */
    public com.google.protobuf.ByteString
        getClientIdSellerBytes() {
      java.lang.Object ref = clientIdSeller_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientIdSeller_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string clientIdSeller = 1;</code>
     * @param value The clientIdSeller to set.
     * @return This builder for chaining.
     */
    public Builder setClientIdSeller(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      clientIdSeller_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string clientIdSeller = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearClientIdSeller() {
      clientIdSeller_ = getDefaultInstance().getClientIdSeller();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string clientIdSeller = 1;</code>
     * @param value The bytes for clientIdSeller to set.
     * @return This builder for chaining.
     */
    public Builder setClientIdSellerBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      clientIdSeller_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object clientIdBuyer_ = "";
    /**
     * <code>string clientIdBuyer = 2;</code>
     * @return The clientIdBuyer.
     */
    public java.lang.String getClientIdBuyer() {
      java.lang.Object ref = clientIdBuyer_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientIdBuyer_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string clientIdBuyer = 2;</code>
     * @return The bytes for clientIdBuyer.
     */
    public com.google.protobuf.ByteString
        getClientIdBuyerBytes() {
      java.lang.Object ref = clientIdBuyer_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientIdBuyer_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string clientIdBuyer = 2;</code>
     * @param value The clientIdBuyer to set.
     * @return This builder for chaining.
     */
    public Builder setClientIdBuyer(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      clientIdBuyer_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string clientIdBuyer = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearClientIdBuyer() {
      clientIdBuyer_ = getDefaultInstance().getClientIdBuyer();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string clientIdBuyer = 2;</code>
     * @param value The bytes for clientIdBuyer to set.
     * @return This builder for chaining.
     */
    public Builder setClientIdBuyerBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      clientIdBuyer_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object symbol_ = "";
    /**
     * <code>string symbol = 3;</code>
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
     * <code>string symbol = 3;</code>
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
     * <code>string symbol = 3;</code>
     * @param value The symbol to set.
     * @return This builder for chaining.
     */
    public Builder setSymbol(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      symbol_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string symbol = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSymbol() {
      symbol_ = getDefaultInstance().getSymbol();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string symbol = 3;</code>
     * @param value The bytes for symbol to set.
     * @return This builder for chaining.
     */
    public Builder setSymbolBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      symbol_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private double price_ ;
    /**
     * <code>double price = 4;</code>
     * @return The price.
     */
    @java.lang.Override
    public double getPrice() {
      return price_;
    }
    /**
     * <code>double price = 4;</code>
     * @param value The price to set.
     * @return This builder for chaining.
     */
    public Builder setPrice(double value) {

      price_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>double price = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrice() {
      bitField0_ = (bitField0_ & ~0x00000008);
      price_ = 0D;
      onChanged();
      return this;
    }

    private int numberOfShares_ ;
    /**
     * <code>int32 numberOfShares = 5;</code>
     * @return The numberOfShares.
     */
    @java.lang.Override
    public int getNumberOfShares() {
      return numberOfShares_;
    }
    /**
     * <code>int32 numberOfShares = 5;</code>
     * @param value The numberOfShares to set.
     * @return This builder for chaining.
     */
    public Builder setNumberOfShares(int value) {

      numberOfShares_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>int32 numberOfShares = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumberOfShares() {
      bitField0_ = (bitField0_ & ~0x00000010);
      numberOfShares_ = 0;
      onChanged();
      return this;
    }

    private long dateUnix_ ;
    /**
     * <code>int64 dateUnix = 6;</code>
     * @return The dateUnix.
     */
    @java.lang.Override
    public long getDateUnix() {
      return dateUnix_;
    }
    /**
     * <code>int64 dateUnix = 6;</code>
     * @param value The dateUnix to set.
     * @return This builder for chaining.
     */
    public Builder setDateUnix(long value) {

      dateUnix_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>int64 dateUnix = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearDateUnix() {
      bitField0_ = (bitField0_ & ~0x00000020);
      dateUnix_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:TransactionHistory)
  }

  // @@protoc_insertion_point(class_scope:TransactionHistory)
  private static final rs.raf.pds.v5.z2.gRPC.TransactionHistory DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.pds.v5.z2.gRPC.TransactionHistory();
  }

  public static rs.raf.pds.v5.z2.gRPC.TransactionHistory getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TransactionHistory>
      PARSER = new com.google.protobuf.AbstractParser<TransactionHistory>() {
    @java.lang.Override
    public TransactionHistory parsePartialFrom(
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

  public static com.google.protobuf.Parser<TransactionHistory> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TransactionHistory> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.pds.v5.z2.gRPC.TransactionHistory getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

