package with.proxy;

public class CustomerService {
	CustomerDAO customerDAO = new CustomerDAOImpl();
	CustomerDAO cachingProxy = new CachingProxy(customerDAO);
	CustomerDAO loggerProxy = new LoggingProxy(cachingProxy);
	CustomerDAO stopWatchProxy = new StopWatchProxy(loggerProxy);
	
    public Customer getCustomer(int customerId) {
    	return stopWatchProxy.findCustomerById(customerId);
    }
}
