package abstractfactory;

public class MockCustomerDAOImpl implements CustomerDAO{

	public void save(Customer customer) {
		System.out.println("MockCustomerDAOImpl saves customer");		
	}
}
