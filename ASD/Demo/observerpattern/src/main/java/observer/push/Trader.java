package observer.push;

public class Trader implements IObserver{

	public void trade(Stock stock) {
		System.out.println("Trader trade stock :" + stock);
	}


	@Override
	public void update(Stock stock) {
		trade(stock);		
	}
}
