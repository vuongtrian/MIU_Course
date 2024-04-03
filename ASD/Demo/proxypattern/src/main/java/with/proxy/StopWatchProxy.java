package with.proxy;

public class StopWatchProxy implements CustomerDAO {
	CustomerDAO customerDAO;

	public StopWatchProxy(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public Customer findCustomerById(int customerId) {
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		Customer customer = customerDAO.findCustomerById(customerId);
		stopwatch.stop();
		System.out.println("The method CustomerDAO.getCustomer took " + stopwatch.getMillis() + " ms");
		return customer;
	}
}
