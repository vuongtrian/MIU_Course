package webshop.order;

import framework.Service;

//@Service(name="MyEmailSender")
@Service
public class EmailSender {
	
    public void sendEmail(String emailAddress, String message){
        System.out.println("EmailSender: send email to address "+emailAddress+" with message: "+message);
    }
    
    public void print() {
    	System.out.println("@Service(name = EmailSender)");
    }
    
}
