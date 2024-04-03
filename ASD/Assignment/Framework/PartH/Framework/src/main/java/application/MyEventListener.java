package application;

import framework.EventListener;
import framework.Service;

@Service
public class MyEventListener {
	
	@EventListener
	public void receiveOrder(String message) {
		System.out.println("MyEventListener traces the message: " + message);
	}

}
