package application;

import framework.Profile;
import framework.Service;

@Service
@Profile("Test")
public class MockCalculatorDAOImpl implements ICalculatorDAO {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("MockCalculatorDAOImpl is called");
	}

}
