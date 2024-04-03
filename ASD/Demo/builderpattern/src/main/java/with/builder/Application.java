package with.builder;

public class Application {

	public static void main(String[] args) {
		Customer customer1 = new Customer.Builder()
				.withFirstName("Mary")
				.withLastname("Jones")
				.withEmail("mjones@gmail.com")
				.withAge(34)
				.isMarried()
				.withNumberOfChildren(3)
				.withPhone("0623416754")
				.withShoesize(8)
				.withYearlyIncome(50000.0)
				.withYearlyAmountSpendOnShoes(2000.0)
				.build();
		System.out.println(customer1);
		
		Customer customer2 = new Customer.Builder()
				.withFirstName("Lucy")
				.withLastname("Jhonson")
				.isNotMarried()
				.withPhone("0698345234")
				.build();
		System.out.println(customer2);

	}
}
