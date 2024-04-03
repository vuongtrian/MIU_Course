package with.proxy;

public class Application {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomer(1);
        System.out.println(customer);
	}
}
