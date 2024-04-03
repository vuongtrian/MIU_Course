package com.FinalProject;

import com.custom.aop.EventListener;
import com.custom.aop.EventService;

@EventService
public class TestEventService {
	@EventListener
	public void receiveMessage(NewTransactionEvent event) {
		System.out.println("Receive Transaction event: " + event.getTransaction().getName());
	}
}
