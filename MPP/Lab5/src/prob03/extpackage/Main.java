package prob03.extpackage;

import java.time.LocalDate;
import prob03.Customer;
import prob03.CustomerOrderFactory;
import prob03.Order;

public class Main {
	public static void main(String[] args) {
//		Customer cust = new Customer("Bob");
		Customer cust = CustomerOrderFactory.addCustomer("Bob");
		Order order = CustomerOrderFactory.newOrder(cust, LocalDate.now());
		order.addItem("Shirt");
		order.addItem("Laptop");

		order = CustomerOrderFactory.newOrder(cust, LocalDate.now());
		order.addItem("Pants");
		order.addItem("Knife set");

		System.out.println(cust.getOrders());
	}
}

		
