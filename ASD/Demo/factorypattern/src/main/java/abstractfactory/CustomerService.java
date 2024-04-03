package abstractfactory;

public class CustomerService {
	private CustomerDAO customerDAO;
	
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO= customerDAO;
	}
	
	public void save(Customer customer) {
		customerDAO.save(customer);
	}
}
