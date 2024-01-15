// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stocks_service.proto

package rs.raf.pds.v5.z2.gRPC;

/**
 * Protobuf type {@code SubscribeUpit}
 */
public final class SubscribeUpit extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:SubscribeUpit)
    SubscribeUpitOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SubscribeUpit.newBuilder() to construct.
  private SubscribeUpit(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SubscribeUpit() {
    symbols_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
    clientId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SubscribeUpit();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SubscribeUpit_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SubscribeUpit_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            rs.raf.pds.v5.z2.gRPC.SubscribeUpit.class, rs.raf.pds.v5.z2.gRPC.SubscribeUpit.Builder.class);
  }

  public static final int SYMBOLS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private com.google.protobuf.LazyStringArrayList symbols_ =
      com.google.protobuf.LazyStringArrayList.emptyList();
  /**
   * <code>repeated string symbols = 1;</code>
   * @return A list containing the symbols.
   */
  public com.google.protobuf.ProtocolStringList
      getSymbolsList() {
    return symbols_;
  }
  /**
   * <code>repeated string symbols = 1;</code>
   * @return The count of symbols.
   */
  public int getSymbolsCount() {
    return symbols_.size();
  }
  /**
   * <code>repeated string symbols = 1;</code>
   * @param index The index of the element to return.
   * @return The symbols at the given index.
   */
  public java.lang.String getSymbols(int index) {
    return symbols_.get(index);
  }
  /**
   * <code>repeated string symbols = 1;</code>
   * @param index The index of the value to return.
   * @return The bytes of the symbols at the given index.
   */
  public com.google.protobuf.ByteString
      getSymbolsBytes(int index) {
    return symbols_.getByteString(index);
  }

  public static final int CLIENTID_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object clientId_ = "";
  /**
   * <code>string clientId = 2;</code>
   * @return The clientId.
   */
  @java.lang.Override
  public java.lang.String getClientId() {
    java.lang.Object ref = clientId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      clientId_ = s;
      return s;
    }
  }
  /**
   * <code>string clientId = 2;</code>
   * @return The bytes for clientId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getClientIdBytes() {
    java.lang.Object ref = clientId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      clientId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    for (int i = 0; i < symbols_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, symbols_.getRaw(i));
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clientId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, clientId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < symbols_.size(); i++) {
        dataSize += computeStringSizeNoTag(symbols_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getSymbolsList().size();
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clientId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, clientId_);
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
    if (!(obj instanceof rs.raf.pds.v5.z2.gRPC.SubscribeUpit)) {
      return super.equals(obj);
    }
    rs.raf.pds.v5.z2.gRPC.SubscribeUpit other = (rs.raf.pds.v5.z2.gRPC.SubscribeUpit) obj;

    if (!getSymbolsList()
        .equals(other.getSymbolsList())) return false;
    if (!getClientId()
        .equals(other.getClientId())) return false;
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
    if (getSymbolsCount() > 0) {
      hash = (37 * hash) + SYMBOLS_FIELD_NUMBER;
      hash = (53 * hash) + getSymbolsList().hashCode();
    }
    hash = (37 * hash) + CLIENTID_FIELD_NUMBER;
    hash = (53 * hash) + getClientId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit parseFrom(
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
  public static Builder newBuilder(rs.raf.pds.v5.z2.gRPC.SubscribeUpit prototype) {
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
   * Protobuf type {@code SubscribeUpit}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SubscribeUpit)
      rs.raf.pds.v5.z2.gRPC.SubscribeUpitOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SubscribeUpit_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SubscribeUpit_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              rs.raf.pds.v5.z2.gRPC.SubscribeUpit.class, rs.raf.pds.v5.z2.gRPC.SubscribeUpit.Builder.class);
    }

    // Construct using rs.raf.pds.v5.z2.gRPC.SubscribeUpit.newBuilder()
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
      symbols_ =
          com.google.protobuf.LazyStringArrayList.emptyList();
      clientId_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return rs.raf.pds.v5.z2.gRPC.StocksServiceOuterClass.internal_static_SubscribeUpit_descriptor;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SubscribeUpit getDefaultInstanceForType() {
      return rs.raf.pds.v5.z2.gRPC.SubscribeUpit.getDefaultInstance();
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SubscribeUpit build() {
      rs.raf.pds.v5.z2.gRPC.SubscribeUpit result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public rs.raf.pds.v5.z2.gRPC.SubscribeUpit buildPartial() {
      rs.raf.pds.v5.z2.gRPC.SubscribeUpit result = new rs.raf.pds.v5.z2.gRPC.SubscribeUpit(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(rs.raf.pds.v5.z2.gRPC.SubscribeUpit result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        symbols_.makeImmutable();
        result.symbols_ = symbols_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.clientId_ = clientId_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof rs.raf.pds.v5.z2.gRPC.SubscribeUpit) {
        return mergeFrom((rs.raf.pds.v5.z2.gRPC.SubscribeUpit)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(rs.raf.pds.v5.z2.gRPC.SubscribeUpit other) {
      if (other == rs.raf.pds.v5.z2.gRPC.SubscribeUpit.getDefaultInstance()) return this;
      if (!other.symbols_.isEmpty()) {
        if (symbols_.isEmpty()) {
          symbols_ = other.symbols_;
          bitField0_ |= 0x00000001;
        } else {
          ensureSymbolsIsMutable();
          symbols_.addAll(other.symbols_);
        }
        onChanged();
      }
      if (!other.getClientId().isEmpty()) {
        clientId_ = other.clientId_;
        bitField0_ |= 0x00000002;
        onChanged();
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
              java.lang.String s = input.readStringRequireUtf8();
              ensureSymbolsIsMutable();
              symbols_.add(s);
              break;
            } // case 10
            case 18: {
              clientId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private com.google.protobuf.LazyStringArrayList symbols_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
    private void ensureSymbolsIsMutable() {
      if (!symbols_.isModifiable()) {
        symbols_ = new com.google.protobuf.LazyStringArrayList(symbols_);
      }
      bitField0_ |= 0x00000001;
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @return A list containing the symbols.
     */
    public com.google.protobuf.ProtocolStringList
        getSymbolsList() {
      symbols_.makeImmutable();
      return symbols_;
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @return The count of symbols.
     */
    public int getSymbolsCount() {
      return symbols_.size();
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @param index The index of the element to return.
     * @return The symbols at the given index.
     */
    public java.lang.String getSymbols(int index) {
      return symbols_.get(index);
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @param index The index of the value to return.
     * @return The bytes of the symbols at the given index.
     */
    public com.google.protobuf.ByteString
        getSymbolsBytes(int index) {
      return symbols_.getByteString(index);
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @param index The index to set the value at.
     * @param value The symbols to set.
     * @return This builder for chaining.
     */
    public Builder setSymbols(
        int index, java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureSymbolsIsMutable();
      symbols_.set(index, value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @param value The symbols to add.
     * @return This builder for chaining.
     */
    public Builder addSymbols(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      ensureSymbolsIsMutable();
      symbols_.add(value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @param values The symbols to add.
     * @return This builder for chaining.
     */
    public Builder addAllSymbols(
        java.lang.Iterable<java.lang.String> values) {
      ensureSymbolsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, symbols_);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSymbols() {
      symbols_ =
        com.google.protobuf.LazyStringArrayList.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);;
      onChanged();
      return this;
    }
    /**
     * <code>repeated string symbols = 1;</code>
     * @param value The bytes of the symbols to add.
     * @return This builder for chaining.
     */
    public Builder addSymbolsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      ensureSymbolsIsMutable();
      symbols_.add(value);
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object clientId_ = "";
    /**
     * <code>string clientId = 2;</code>
     * @return The clientId.
     */
    public java.lang.String getClientId() {
      java.lang.Object ref = clientId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string clientId = 2;</code>
     * @return The bytes for clientId.
     */
    public com.google.protobuf.ByteString
        getClientIdBytes() {
      java.lang.Object ref = clientId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string clientId = 2;</code>
     * @param value The clientId to set.
     * @return This builder for chaining.
     */
    public Builder setClientId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      clientId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string clientId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearClientId() {
      clientId_ = getDefaultInstance().getClientId();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string clientId = 2;</code>
     * @param value The bytes for clientId to set.
     * @return This builder for chaining.
     */
    public Builder setClientIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      clientId_ = value;
      bitField0_ |= 0x00000002;
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


    // @@protoc_insertion_point(builder_scope:SubscribeUpit)
  }

  // @@protoc_insertion_point(class_scope:SubscribeUpit)
  private static final rs.raf.pds.v5.z2.gRPC.SubscribeUpit DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new rs.raf.pds.v5.z2.gRPC.SubscribeUpit();
  }

  public static rs.raf.pds.v5.z2.gRPC.SubscribeUpit getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SubscribeUpit>
      PARSER = new com.google.protobuf.AbstractParser<SubscribeUpit>() {
    @java.lang.Override
    public SubscribeUpit parsePartialFrom(
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

  public static com.google.protobuf.Parser<SubscribeUpit> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SubscribeUpit> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public rs.raf.pds.v5.z2.gRPC.SubscribeUpit getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

