package without.builder;

public class ApplicationUsingConstructor {

	public static void main(String[] args) {
		Customer customer = new Customer("Mary", "Jones", "0623416754", "mjones@gmail.com", 34, 3, 8, true, 50000.0, 2000.0);
		System.out.println(customer);

	}
}
