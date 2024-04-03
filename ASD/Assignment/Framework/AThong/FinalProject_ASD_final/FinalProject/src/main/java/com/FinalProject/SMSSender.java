package com.FinalProject;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.custom.aop.Async;

@Service
public class SMSSender {
    @Async
    @EventListener
    public void onEvent(NewTransactionEvent event) {
        System.out.println("SMS Sender received new transaction event :" + event.getTransaction());
    }
}
