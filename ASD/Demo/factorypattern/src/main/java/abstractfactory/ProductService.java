package abstractfactory;

public class ProductService {
	private ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO= productDAO;
	}
	
	public void save(Product product) {
		productDAO.save(product);
	}
}
