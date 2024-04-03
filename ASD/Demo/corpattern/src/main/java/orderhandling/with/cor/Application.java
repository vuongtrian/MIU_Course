package orderhandling.with.cor;

import java.io.IOException;

public class Application {

	public static void main(String[] args) {		
		OrderReceiver orderReceiver = new OrderReceiver();
		// create the chain
		CompanyBTexasOrderHandler companyBTexasOrderHandler = new CompanyBTexasOrderHandler(null);
		CompanyBNewYorkOrderHandler companyBNewYorkOrderHandler = new CompanyBNewYorkOrderHandler(companyBTexasOrderHandler);
		CompanyAOrderHandler companyAOrderHandler = new CompanyAOrderHandler(companyBNewYorkOrderHandler);
		
		orderReceiver.setOrderHandler(companyAOrderHandler);
		try {
			orderReceiver.receiveOrder("order1.txt");
			orderReceiver.receiveOrder("order2.txt");
			orderReceiver.receiveOrder("order3.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
