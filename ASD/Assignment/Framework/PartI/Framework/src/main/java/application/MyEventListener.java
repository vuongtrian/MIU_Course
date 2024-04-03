package application;

import framework.Async;
import framework.EventListener;
import framework.Service;

@Service
public class MyEventListener {
	
	@EventListener
	@Async
	public void receiveOrder(String message) {
		System.out.println("MyEventListener traces the message: " + message);
	}

}
