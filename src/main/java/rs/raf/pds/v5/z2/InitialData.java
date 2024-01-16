package rs.raf.pds.v5.z2;

import rs.raf.pds.v5.z2.gRPC.Stock;

public class InitialData {
	static String[][] stockData = {{"USFD", "US Foods Holding Corp. Common Stock", "46.87", "0.95", "1704491119"},
			{"LRCX", "Lam Research Corporation Common Stock", "732.38", "1.3", "1704491119"},
			{"ABBV", "AbbVie Inc. Common Stock", "161.91", "0.45", "1704491119"},
			{"WMT", "Walmart Inc. Common Stock", "156.21", "-1.55", "1704491119"},
			{"TMO", "Thermo Fisher Scientific Inc Common Stock", "534.34", "-3.02", "1704491119"},
			{"ADSK", "Autodesk Inc. Common Stock", "230.25", "1.33", "1704491119"},
			{"BRK/A", "Berkshire Hathaway Inc.", "554493.52500000002", "2943.545", "1704491119"},
			{"AAPL", "Apple Inc. Common Stock", "181.10", "-0.81", "1704491119"},
			{"ASR", "Grupo Aeroportuario del Sureste S.A. de C.V. Common Stock", "286.23", "5.9", "1704491119"},
			{"ORLY", "O'Reilly Automotive Inc. Common Stock", "927.20", "-8.6", "1704491119"},
			{"ACN", "Accenture plc Class A Ordinary Shares (Ireland)", "337.4521", "0.3621", "1704491119"},
			{"ROK", "Rockwell Automation Inc. Common Stock", "304.57", "-0.1", "1704491119"},
			{"MSFT", "Microsoft Corporation Common Stock", "368.36", "0.42", "1704491119"},
			{"SCHW", "Charles Schwab Corporation (The) Common Stock", "67.555", "0.665", "1704491119"},
			{"COST", "Costco Wholesale Corporation Common Stock", "654.51", "6.16", "1704491119"},
			{"UBS", "UBS Group AG Registered Ordinary Shares", "29.94", "0.37", "1704491119"},
			{"BKH", "Black Hills Corporation Common Stock", "55.26", "0.29", "1704491119"},
			{"LXP", "LXP Industrial Trust Common Stock (Maryland REIT)", "9.645", "0.015", "1704491119"},
			{"HSBC", "HSBC Holdings plc. Common Stock", "40.73", "0.42", "1704491119"},
			{"NVDA", "NVIDIA Corporation Common Stock", "492.0153", "12.0353", "1704491119"},
			{"REGN", "Regeneron Pharmaceuticals Inc. Common Stock", "917.665", "5.495", "1704491119"},
			{"NYCB", "New York Community Bancorp Inc. Common Stock", "10.465", "0.245", "1704491119"},
			{"OSK", "Oshkosh Corporation (Holding Company)Common Stock", "105.29", "1.49", "1704491119"},
			{"MSFT", "Microsoft Corporation Common Stock", "368.36", "0.42", "1704491119"},
			{"AZN", "AstraZeneca PLC American Depositary Shares", "68.605", "-0.175", "1704491119"},
			{"BRK/B", "Berkshire Hathaway Inc.", "365.785", "2.105", "1704491119"},
			{"PPG", "PPG Industries Inc. Common Stock", "145.96", "1.05", "1704491119"},
			{"IGIC", "International General Insurance Holdings Ltd. Ordinary Share", "12.99", "0.16", "1704491119"},
			{"BSBR", "Banco Santander Brasil SA American Depositary Shares each representing one unit", "6.555", "0.135", "1704491119"},
			{"XHR", "Xenia Hotels & Resorts Inc. Common Stock", "13.325", "0.075", "1704491119"},
			{"RY", "Royal Bank Of Canada Common Stock", "100.73", "0.56", "1704491119"},
			{"AVGO", "Broadcom Inc. Common Stock", "1048.0982", "-0.9118", "1704491119"},
			{"ROK", "Rockwell Automation Inc. Common Stock", "304.57", "-0.1", "1704491119"},
			{"USB", "U.S. Bancorp Common Stock", "44.05", "0.84", "1704491119"},
			{"FCX", "Freeport-McMoRan Inc. Common Stock", "41.40", "-0.15", "1704491119"},
			{"MSFT", "Microsoft Corporation Common Stock", "368.36", "0.42", "1704491119"},
			{"PEP", "PepsiCo Inc. Common Stock", "168.68", "-2.79", "1704491119"},
			{"CET", "Central Securities Corporation Common Stock", "37.425", "0.105", "1704491119"},
			{"WM", "Waste Management Inc. Common Stock", "177.3672", "-1.4228", "1704491119"},
			{"META", "Meta Platforms Inc. Class A Common Stock", "351.97", "4.85", "1704491119"},
			};
//			static String[][] stockData = {{"USFD", "US Foods Holding Corp. Common Stock", "46.87", "0.95", "1704491119"},
//			{"LRCX", "Lam Research Corporation Common Stock", "732.38", "1.3", "1704491119"},
//			};
	public static Stock[] initStocks(){
		Stock[] stock = new Stock[stockData.length];
		int i = 0;
		for (String[] dataS:stockData) {
			Stock s = Stock.newBuilder()
					.setSymbol(dataS[0])
					.setCompanyName(dataS[1])
					.setStartPrice(Float.parseFloat(dataS[2]))
					.setChangeInPrice(Float.parseFloat(dataS[3]))
					.setDateUnix(Long.parseLong(dataS[4]))
					.build();
			stock[i++] = s;
		}
		return stock;
	}
}
