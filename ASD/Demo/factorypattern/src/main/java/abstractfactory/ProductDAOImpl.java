package abstractfactory;

public class ProductDAOImpl implements ProductDAO{

	public void save(Product product) {
		System.out.println("ProductDAOImpl saves product");		
	}

}
