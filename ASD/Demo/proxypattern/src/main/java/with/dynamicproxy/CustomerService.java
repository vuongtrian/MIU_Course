package with.dynamicproxy;

import java.lang.reflect.Proxy;

public class CustomerService {
	CustomerDAO customerDAO = new CustomerDAOImpl();
	ClassLoader classLoader = CustomerDAO.class.getClassLoader();
	CustomerDAO cachingProxy = 
			(CustomerDAO) Proxy.newProxyInstance(classLoader, 
					                             new Class[] { CustomerDAO.class },
			                                     new CachingProxy(customerDAO));
	CustomerDAO loggingProxy = 
			(CustomerDAO) Proxy.newProxyInstance(classLoader, 
					                             new Class[] { CustomerDAO.class },
			                                     new LoggingProxy(cachingProxy));
	CustomerDAO stopwatchProxy = 
			(CustomerDAO) Proxy.newProxyInstance(classLoader, 
					                             new Class[] { CustomerDAO.class },
			                                     new StopWatchProxy(loggingProxy));
	
	public Customer getCustomer(int customerId) {
		return stopwatchProxy.findCustomerById(customerId);
	}
}
