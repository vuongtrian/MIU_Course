package bank.service;

public class EmailSender implements IEmailSender{

    private static EmailSender emailSender;

    private EmailSender() {
        if (emailSender != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static synchronized EmailSender getEmailSender() {
        if (emailSender == null) {
            emailSender = new EmailSender();
        }
        return emailSender;
    }

    @Override
    public void send() {
        System.out.println("EmailSender sent email!");
    }
}
