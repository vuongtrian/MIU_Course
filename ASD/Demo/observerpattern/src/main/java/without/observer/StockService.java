package without.observer;


public class StockService {
	private HistoryLogger historyLogger;
	private Trader trader;
	private StockNotifier stockNotifier;

	public void changeStockValue(String stockName, double value) {
		Stock stock = new Stock(stockName, value);
		historyLogger.log(stock);
		trader.trade(stock);
		stockNotifier.handleStockChange(stock);
	}

	public void setHistoryLogger(HistoryLogger historyLogger) {
		this.historyLogger = historyLogger;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public void setStockNotifier(StockNotifier stockNotifier) {
		this.stockNotifier = stockNotifier;
	}
	

}
