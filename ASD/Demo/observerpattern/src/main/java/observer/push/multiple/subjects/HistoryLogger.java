package observer.push.multiple.subjects;

public class HistoryLogger implements StockValueObserver {

	public void log(Stock stock) {
		System.out.println("HistoryLogger log stock :" + stock);
	}

	@Override
	public void update(Stock stock) {
		log(stock);
	}
}
