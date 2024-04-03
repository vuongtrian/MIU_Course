package abstractfactory;


public class Application {

	public static void main(String[] args) {
		Product product = new Product(3324, "DJI Mavic 2 Pro drone");
		Customer customer = new Customer("Frank Brown");
		
		DaoFactory mainfactory = new DaoFactory();
		MyFactory factory = mainfactory.getFactoryInstance();
		
		ProductDAO productDao = factory.getProductDAO();
		CustomerDAO customerDao = factory.getCustomerDAO();
		
		ProductService productService = new ProductService(productDao);
		productService.save(product);
		CustomerService customerService = new CustomerService(customerDao);
		customerService.save(customer);
	}
}
