package com.FinalProject;

public interface IEmailSender {
    void sendEmail();
    public void onEmailEvent(NewTransactionEvent event);
}
