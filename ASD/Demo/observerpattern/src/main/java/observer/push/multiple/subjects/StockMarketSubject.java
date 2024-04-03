package observer.push.multiple.subjects;

import java.util.ArrayList;
import java.util.Collection;


public class StockMarketSubject  {
  private Collection<StockMarketObserver> observerlist = new ArrayList<StockMarketObserver>();
  
  public void addObserver(StockMarketObserver observer){
	  observerlist.add(observer);
  }
  
  public void donotify(boolean stockMarketOpen){
	  for (StockMarketObserver observer: observerlist){
		  observer.update(stockMarketOpen);
	  }
  }
  
}
