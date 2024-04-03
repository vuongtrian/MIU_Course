package with.factory;

public class MockProductDAOImpl implements ProductDAO{

	public void save(Product product) {
		System.out.println("MockProductDAOImpl saves product");
		
	}
}
