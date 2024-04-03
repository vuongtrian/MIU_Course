package miu.edu.WebShop.Itegration;

import org.springframework.stereotype.Component;

@Component
public class EmailSenderEvent {
    public EmailSenderEvent() {
    }

    public void sendEmail(String emailAddress, String message) {
        System.out.println("EmailSender: send email to address " + emailAddress + " with message: " + message);
    }
}
