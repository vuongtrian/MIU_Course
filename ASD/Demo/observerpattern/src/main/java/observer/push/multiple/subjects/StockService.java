package observer.push.multiple.subjects;

public class StockService extends StockValueSubject{
	private boolean stockMarketOpen=false;
	private StockMarketSubject stockMarketSubject;

	public void changeStockValue(String stockName, double value) {
		Stock stock = new Stock(stockName, value);
		donotify(stock);
	}
	
	public void openStockMarket() {
		stockMarketOpen=true;
		stockMarketSubject.donotify(stockMarketOpen);
	}
	
	public void closeStockMarket() {
		stockMarketOpen=false;
		stockMarketSubject.donotify(stockMarketOpen);
	}

	public StockMarketSubject getStockMarketSubject() {
		return stockMarketSubject;
	}

	public void setStockMarketSubject(StockMarketSubject stockMarketSubject) {
		this.stockMarketSubject = stockMarketSubject;
	}
}
