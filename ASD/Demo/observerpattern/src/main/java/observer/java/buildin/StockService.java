package observer.java.buildin;

import java.util.Observable;

public class StockService extends Observable{

	public void changeStockValue(String stockName, double value) {
		Stock stock = new Stock(stockName, value);
		setChanged();
		notifyObservers(stock);
	}
}
