package orderhandling.with.strategy;

public class CompanyBTexasOrderHandler implements OrderHandler {

	@Override
	public void handleOrder(String orderContent) {
		System.out.println("handle order for CompanyB from Texas");
	}
}
