package orderhandling.without.cor;

import java.io.IOException;

public class OrderReceiver {

	public void receiveOrder(String fileName) throws IOException {
		FileReader fileReader = new FileReader();
		String orderContent = fileReader.getStringFromFile(fileName);
		handleOrder(orderContent);
	}

	public void handleOrder(String orderContent) {
		if (orderContent.startsWith("CompanyA")) {
			System.out.println("handle order for CompanyA");
		} else if (orderContent.lastIndexOf("CompanyB") != -1) {
			if (orderContent.lastIndexOf("New York") != -1) {
				System.out.println("handle order for CompanyB from New York");
			} else if (orderContent.lastIndexOf("Texas") != -1) {
				System.out.println("handle order for CompanyB from Texas");
			}
		}
	}
}
