package with.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements CustomerDAO{
	CustomerDAO customerDAO;
	Map<Integer,Customer> customerCache = new HashMap<Integer,Customer>();

	public CachingProxy(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	public Customer findCustomerById(int customerId) {
		Customer cachedCustomer = customerCache.get(customerId);
		if (cachedCustomer == null) {
		  Customer customer = customerDAO.findCustomerById(customerId);
		  customerCache.put(customerId, customer);
		  return customer;
		}
		else
		  return cachedCustomer;
	}
}

