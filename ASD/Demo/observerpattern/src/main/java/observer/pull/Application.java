package observer.pull;


public class Application {

	public static void main(String[] args) {
		StockService stockService = new StockService();
		HistoryLogger historyLogger= new HistoryLogger(stockService);
		Trader trader = new Trader(stockService);
		StockNotifier stockNotifier = new StockNotifier(stockService);
		
		stockService.addObserver(historyLogger);
		stockService.addObserver(trader);
		stockService.addObserver(stockNotifier);
		
		stockService.changeStockValue("AMZN", 2310.80);
		stockService.changeStockValue("MSFT", 890.45);

	}
}
