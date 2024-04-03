package orderhandling.with.strategy;

import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		OrderReceiver orderReceiver = new OrderReceiver();
		FileReader fileReader = new FileReader();
		try {
			String orderContent = fileReader.getStringFromFile("order1.txt");
			setOrderHandler(orderReceiver, orderContent);
			orderReceiver.handleOrder(orderContent);
			
			orderContent = fileReader.getStringFromFile("order2.txt");
			setOrderHandler(orderReceiver, orderContent);
			orderReceiver.handleOrder(orderContent);
			
			orderContent = fileReader.getStringFromFile("order3.txt");
			setOrderHandler(orderReceiver, orderContent);
			orderReceiver.handleOrder(orderContent);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void setOrderHandler(OrderReceiver orderReceiver, String orderContent) {
		if (orderContent.startsWith("CompanyA")) {
			orderReceiver.setOrderHandler(new CompanyAOrderHandler());
		} else if (orderContent.lastIndexOf("CompanyB") != -1) {
			if (orderContent.lastIndexOf("New York") != -1) {
				orderReceiver.setOrderHandler(new CompanyBNewYorkOrderHandler());
			} else if (orderContent.lastIndexOf("Texas") != -1) {
				orderReceiver.setOrderHandler(new CompanyBTexasOrderHandler());
			}
		}
	}
}
