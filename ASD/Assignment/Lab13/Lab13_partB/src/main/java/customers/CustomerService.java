package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	@Autowired
	ICustomerDAO customerDAO;
	@Autowired
	IEmailSender emailSender;
	@Autowired
	ApplicationEventPublisher publisher;

	public void addCustomer(String name, String email, String street, String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
		// publish event
		publisher.publishEvent(new NewAccountEvent(customer.toString()));
	}

	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void setEmailSender(IEmailSender emailSender) {
		this.emailSender = emailSender;
	}
	
}
