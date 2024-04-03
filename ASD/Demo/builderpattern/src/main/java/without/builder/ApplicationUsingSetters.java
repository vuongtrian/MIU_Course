package without.builder;

public class ApplicationUsingSetters {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setFirstName("Mary");
		customer.setLastname("Jones");
		customer.setPhone("0623416754");
		customer.setEmail("mjones@gmail.com");
		customer.setAge(34);
		customer.setNumberOfChildren(3);
		customer.setShoesize(8);
		customer.setMarried(true);
		customer.setYearlyIncome(50000.0);
		customer.setYearlyAmountSpendOnShoes(2000.0);
		System.out.println(customer);

	}

}
