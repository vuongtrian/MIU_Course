package with.proxy;

public class LoggingProxy implements CustomerDAO {
	CustomerDAO customerDAO;
	Logger logger = new Logger();

	public LoggingProxy(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public Customer findCustomerById(int customerId) {
		Customer customer = customerDAO.findCustomerById(customerId);
		logger.log("getting customer with id= " + customerId);
		return customer;
	}
}
