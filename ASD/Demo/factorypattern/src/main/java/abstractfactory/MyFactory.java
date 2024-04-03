package abstractfactory;

public interface MyFactory {
	public CustomerDAO getCustomerDAO();
	public ProductDAO getProductDAO();
}
