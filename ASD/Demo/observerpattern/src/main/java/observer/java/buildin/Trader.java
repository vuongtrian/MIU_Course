package observer.java.buildin;

import java.util.Observable;
import java.util.Observer;

public class Trader implements Observer{

	public void trade(Stock stock) {
		System.out.println("Trader trade stock :" + stock);
	}

	
	public void update(Observable observable, Object stock) {
		trade((Stock) stock);
	}
}
