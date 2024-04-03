package webshop.products;

import framework.Autowired;
import framework.Service;

//@Service(name="MyProductService")
@Service
public class ProductService {
    
//	@Autowired
    ProductDAO productDAO;
    
    public ProductService() {
    	
    }
	
    @Autowired
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

    public void addProduct(int productNumber, String name, double price){
        productDAO.save(new Product(productNumber, name, price));
    }

    public Product getProduct(int productNumber){
        return productDAO.find(productNumber);
    }

    public void removeProduct(int productNumber){
        productDAO.remove(productNumber);
    }
    
    public void print() {
    	System.out.println("@Service(name = ProductService)");
    	productDAO.print();
    }
}
