package webshop;

import framework.FWContext;
import webshop.order.Address;
import webshop.order.CreditCardPayment;
import webshop.order.Customer;
import webshop.order.Order;
import webshop.order.OrderService;
import webshop.order.Payment;
import webshop.products.Product;
import webshop.products.ProductService;
import webshop.shopping.ShoppingCart;
import webshop.shopping.ShoppingService;

public class Application {
	
	public static void main(String[] args) {
		FWContext fWContext = new FWContext();
		
		ShoppingService shoppingService = (ShoppingService) fWContext.getBean(ShoppingService.class);
		ProductService productService = (ProductService) fWContext.getBean(ProductService.class);
		OrderService orderService = (OrderService) fWContext.getBean(OrderService.class);
		
		productService.addProduct(123,"Product1",25.50);
		productService.addProduct(124,"Product2",20.50);
		productService.addProduct(125,"Product3",13.75);

		Product product1 = productService.getProduct(123);
		Product product2 = productService.getProduct(124);

		shoppingService.createCart(1);
		shoppingService.addToCart(1, product1,4);
		shoppingService.addToCart(1, product2,2);
		shoppingService.changeQuantity(1, 124,6);

		ShoppingCart cart = shoppingService.getCart(1);
		System.out.println(cart);

		orderService.createOrder(cart, 1);

		Order order= orderService.getOrder(1);
		order.setCustomer(new Customer("Frank Brown","fbrown@acme.com","465-234-9080"));
		order.setBillingAddress(new Address("Mainstreet 1", "Fairfield", "52556"));
		order.setShippingAddress(new Address("Mainstreet 34", "Fairfield", "52556"));
		Payment payment = new Payment(300.00, "12/07/2023");
		payment.setPaymentType(new CreditCardPayment("1289 7654 7432", "08/26", "VISA"));
		order.setPayment(payment);
		orderService.saveOrder(order);

		System.out.println(order);

		orderService.placeOrder(1);
	}
	
}
