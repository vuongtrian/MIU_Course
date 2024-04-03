package application;

import framework.Profile;
import framework.Service;

@Service
@Profile("Production")
public class CalculatorDAOImpl implements ICalculatorDAO {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("CalculatorDAOImpl is called");
	}

}