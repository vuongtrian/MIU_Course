package with.factory;

public class ProductService {
	ProductDAO productDAO;
	
	public ProductService() {
		productDAO=ProductDAOFactory.getProductDAOInstance();
	}
	
	public void save(Product product) {
		productDAO.save(product);
	}
}
