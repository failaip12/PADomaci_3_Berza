package rs.raf.pds.v5.z2;

import java.io.Serializable;

public record TransactionNotification(String symbol, double price, int numberOfShares, boolean buy) implements Serializable {}
