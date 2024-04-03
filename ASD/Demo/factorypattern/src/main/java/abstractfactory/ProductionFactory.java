package abstractfactory;

public class ProductionFactory implements MyFactory{

	public CustomerDAO getCustomerDAO() {
       return new CustomerDAOImpl();
	}

	public ProductDAO getProductDAO() {
		return new ProductDAOImpl();
	}

}
