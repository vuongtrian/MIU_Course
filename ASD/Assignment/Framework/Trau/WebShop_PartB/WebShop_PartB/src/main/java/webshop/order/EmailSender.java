package webshop.order;

import framework.Service;
import framework.Qualifier;

//@Service(name="MyEmailSender")
@Service
@Qualifier("emailSender")
public class EmailSender implements ISender {
	
	@Override
    public void sendEmail(String emailAddress, String message) {
        System.out.println("EmailSender: send email to address "+emailAddress+" with message: "+message);
    }
    
	@Override
    public void print() {
    	System.out.println("@Service(name = EmailSender)");
    }
    
}
