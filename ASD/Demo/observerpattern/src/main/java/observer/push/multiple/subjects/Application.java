package observer.push.multiple.subjects;


public class Application {

	public static void main(String[] args) {
		StockService stockService = new StockService();
		HistoryLogger historyLogger= new HistoryLogger();
		Trader trader = new Trader();
		StockNotifier stockNotifier = new StockNotifier();
		
		stockService.addObserver(historyLogger);
		stockService.addObserver(trader);
		stockService.addObserver(stockNotifier);
		
		StockMarketSubject stockMarketSubject = new StockMarketSubject();
		StockMarketView stockMarketView = new StockMarketView();
		stockMarketSubject.addObserver(stockMarketView);
		stockService.setStockMarketSubject(stockMarketSubject);
		
		stockService.openStockMarket();
		stockService.changeStockValue("AMZN", 2310.80);
		stockService.changeStockValue("MSFT", 890.45);
		stockService.closeStockMarket();

	}
}
