package com.FinalProject;


import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.custom.aop.Value;

@Service
@EnableAsync
public class EmailSender implements IEmailSender {
    @Value("smtpserver")
    private String smtpServer;
    
    public void sendEmail() {
        System.out.println("Sending email using smtp server " + smtpServer);
    }

    @Async
    @EventListener
    public void onEmailEvent(NewTransactionEvent event) {
        System.out.println("Email Sender received new transaction event :" + event.getTransaction());
    }
}
