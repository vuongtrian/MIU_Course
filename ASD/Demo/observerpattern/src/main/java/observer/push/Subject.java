package observer.push;

import java.util.ArrayList;
import java.util.Collection;


public class Subject  {
  private Collection<IObserver> observerlist = new ArrayList<IObserver>();
  
  public void addObserver(IObserver observer){
	  observerlist.add(observer);
  }
  
  public void donotify(Stock stock){
	  for (IObserver observer: observerlist){
		  observer.update(stock);
	  }
  }
  
}
