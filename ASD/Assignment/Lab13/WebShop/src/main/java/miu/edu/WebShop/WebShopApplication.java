package miu.edu.WebShop;

import miu.edu.WebShop.Domain.*;
import miu.edu.WebShop.Service.OrderService;
import miu.edu.WebShop.Service.ProductService;
import miu.edu.WebShop.Service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

	@Autowired
	ProductService productService;

	@Autowired
	private ShoppingService shoppingService;

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		productService.addProduct(123,"Product1",25.50);
		productService.addProduct(124,"Product2",20.50);
		productService.addProduct(125,"Product3",13.75);

		Product product1 = productService.getProduct(123);
		Product product2 = productService.getProduct(124);

		shoppingService.createCart(1);
		shoppingService.addToCart(1, product1,4);
		shoppingService.addToCart(1, product2,2);
		shoppingService.changeQuantity(1,124,5);

		ShoppingCart cart = shoppingService.getCart(1);
		System.out.println(cart);


		orderService.createOrder(cart, 1);

		Order order= orderService.getOrder(1);
//		order.setOrdernumber("ORD3429");
		order.setCustomer(new Customer("Frank Brown","fbrown@acme.com","465-234-9080"));
		order.setBillingAddress(new Address("Mainstreet 1", "Fairfield", "52557"));
		order.setShippingAddress(new Address("Mainstreet 3", "Fairfield", "52557"));
		Payment payment = new Payment(300.00, "12/07/2023");
		payment.setPaymentType(new CreditCardPayment("fbrown@acme.com", "07-28", "Silver"));
		order.setPayment(payment);
		orderService.saveOrder(order);

		System.out.println(order);

		orderService.placeOrder(1);
	}
}
