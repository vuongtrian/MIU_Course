package webshop.order;

import framework.Service;
import framework.Value;
import framework.Qualifier;

//@Service(name="MyEmailSender")
@Service
@Qualifier("emailSender")
public class EmailSender implements ISender {
	
	@Value("smtpserver")
	String outgoingMailServer;
	
	@Override
    public void sendEmail(String emailAddress, String message) {
        System.out.println("EmailSender: send email to address "+emailAddress+" with message: "+message + " on MailServer: " + outgoingMailServer);
    }
    
	@Override
    public void print() {
    	System.out.println("@Service(name = EmailSender)");
    }

	@Override
	public String getOutgoingMailServer() {
		// TODO Auto-generated method stub
		return outgoingMailServer;
	}
	
}
