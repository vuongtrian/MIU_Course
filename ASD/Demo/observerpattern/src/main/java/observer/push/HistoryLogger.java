package observer.push;

public class HistoryLogger implements IObserver {

	public void log(Stock stock) {
		System.out.println("HistoryLogger log stock :" + stock);
	}

	@Override
	public void update(Stock stock) {
		log(stock);
	}
}
