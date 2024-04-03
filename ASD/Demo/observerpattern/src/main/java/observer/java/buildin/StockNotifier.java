package observer.java.buildin;

import java.util.Observable;
import java.util.Observer;

public class StockNotifier implements Observer {

	public void handleStockChange(Stock stock) {
		System.out.println("StockNotifier handle stock :" + stock);
	}

	public void update(Observable observable, Object stock) {
		handleStockChange((Stock) stock);
	}
}
