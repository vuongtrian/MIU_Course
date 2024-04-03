package simple;

public class Application {

	public static void main(String[] args) {
		// with constructor
		CreditCard creditCard = new CreditCard("visa", "1232786598763429", 2500.0, 10);

		//with factory
		CreditCard creditCard2 = CreditCardFactory.getCreditCardInstance("visa", "1232786598763429", 2500.0, 10);
	}

}
