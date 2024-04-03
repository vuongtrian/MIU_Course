package observer.pull;

import java.util.ArrayList;
import java.util.Collection;


public class Subject  {
  private Collection<Observer> observerlist = new ArrayList<Observer>();
  
  public void addObserver(Observer observer){
	  observerlist.add(observer);
  }
  
  public void donotify(){
	  for (Observer observer: observerlist){
		  observer.update();
	  }
  }
  
}
