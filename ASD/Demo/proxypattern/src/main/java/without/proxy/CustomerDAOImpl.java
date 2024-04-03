package without.proxy;

public class CustomerDAOImpl implements CustomerDAO{
	public Customer getCustomer(int customerId) {
    	return new Customer(customerId, "Frank Brown");
    }
}
