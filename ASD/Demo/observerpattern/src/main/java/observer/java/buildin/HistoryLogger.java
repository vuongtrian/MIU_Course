package observer.java.buildin;

import java.util.Observable;
import java.util.Observer;

public class HistoryLogger implements Observer {

	public void log(Stock stock) {
		System.out.println("HistoryLogger log stock :" + stock);
		;
	}

	public void update(Observable observable, Object stock) {
		log((Stock) stock);
	}

}
