package abstractfactory;

public class MockFactory implements MyFactory{
	public CustomerDAO getCustomerDAO() {
		return new MockCustomerDAOImpl();
	  }

	  public ProductDAO getProductDAO() {
		  return new MockProductDAOImpl();
	  }

}
