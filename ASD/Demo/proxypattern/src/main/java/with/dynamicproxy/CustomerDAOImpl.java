package with.dynamicproxy;

public class CustomerDAOImpl implements CustomerDAO{
	public Customer findCustomerById(int customerId) {
    	return new Customer(customerId, "Frank Brown");
    }
}
