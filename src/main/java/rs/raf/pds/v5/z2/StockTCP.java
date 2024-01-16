package rs.raf.pds.v5.z2;

import java.io.Serializable;

public record StockTCP(String symbol, String companyName, double startPrice, double changeInPrice, long dateUnix) implements Serializable {}