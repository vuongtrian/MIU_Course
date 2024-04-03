package observer.push;

public class StockService extends Subject{

	public void changeStockValue(String stockName, double value) {
		Stock stock = new Stock(stockName, value);
		donotify(stock);
	}
}
