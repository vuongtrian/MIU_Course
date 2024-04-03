package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private ICustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.addProduct();
		customerService.addCustomer("Frank Brown", "fbrown@acme.com", "mainstreet 5", "Chicago", "60613");
	}
}
