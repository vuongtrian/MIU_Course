package orderhandling.with.strategy;

public class CompanyAOrderHandler implements OrderHandler{

	@Override
	public void handleOrder(String orderContent) {
		System.out.println("handle order for CompanyA");		
	}

}
