package observer.push.multiple.subjects;

import java.util.ArrayList;
import java.util.Collection;


public class StockValueSubject  {
  private Collection<StockValueObserver> observerlist = new ArrayList<StockValueObserver>();
  
  public void addObserver(StockValueObserver observer){
	  observerlist.add(observer);
  }
  
  public void donotify(Stock stock){
	  for (StockValueObserver observer: observerlist){
		  observer.update(stock);
	  }
  }
  
}
