package bank.service;

public class MockEmailSender implements IEmailSender{
    @Override
    public void send() {
        System.out.println("MockEmailSender sent email...");
    }
}
