package without.proxy;

public class CustomerService {
	CustomerDAO customerDAO = new CustomerDAOImpl();
    public Customer getCustomer(int customerId) {
    	return customerDAO.getCustomer(customerId);
    }
}
