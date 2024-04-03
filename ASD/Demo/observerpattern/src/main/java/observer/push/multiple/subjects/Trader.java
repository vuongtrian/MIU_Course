package observer.push.multiple.subjects;

public class Trader implements StockValueObserver{

	public void trade(Stock stock) {
		System.out.println("Trader trade stock :" + stock);
	}


	@Override
	public void update(Stock stock) {
		trade(stock);		
	}
}
