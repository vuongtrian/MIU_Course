package observer.push;

public class StockNotifier implements IObserver {

	public void handleStockChange(Stock stock) {
		System.out.println("StockNotifier handle stock :" + stock);
	}

	@Override
	public void update(Stock stock) {
		handleStockChange(stock);
	}

}
