package abstractfactory;

public class CustomerDAOImpl implements CustomerDAO{

	public void save(Customer customer) {
		System.out.println("CustomerDAOImpl saves customer");	
	}

}
