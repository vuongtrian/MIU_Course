package observer.push.multiple.subjects;

public class StockNotifier implements StockValueObserver {

	public void handleStockChange(Stock stock) {
		System.out.println("StockNotifier handle stock :" + stock);
	}

	@Override
	public void update(Stock stock) {
		handleStockChange(stock);
	}

}
