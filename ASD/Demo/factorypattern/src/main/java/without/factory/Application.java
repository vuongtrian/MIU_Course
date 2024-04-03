package without.factory;


public class Application {

	public static void main(String[] args) {
		Product product = new Product(3324, "DJI Mavic 2 Pro drone");
		
		ProductService productService = new ProductService();
		productService.save(product);
	}
}
