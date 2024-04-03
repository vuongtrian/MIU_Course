package with.templatemethod;

import without.templatemethod.PaymentProcessor;

public class Application {

	public static void main(String[] args) {
		Payment visaPayment = new VisaPayment(new Customer("Frank Brown", "fbrown@gmail.com"),
				new VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112));
		visaPayment.proccessPayment(125.75, "USD");


//		without.templatemethod.Customer customer1 = new without.templatemethod.Customer("Frank Brown", "fbrown@gmail.com");
//		without.templatemethod.VisaCard visaCard = new VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112);
//		PaymentProcessor paymentProcessor = new PaymentProcessor();
//		paymentProcessor.proccessPayment(125.75, "USD", "visa", customer1, visaCard, null);
//
//		System.out.println("------------------------------------");
//
//		without.templatemethod.Customer customer2 = new Customer("John Doe", "jdoe@gmail.com");
//		paymentProcessor.proccessPayment(175000.0, "INR", "paypal", customer2, null, "jdoe@gmail.com");

	}
}
