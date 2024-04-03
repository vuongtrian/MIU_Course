package orderhandling.with.cor;

public class CompanyBTexasOrderHandler extends OrderHandler {

	public CompanyBTexasOrderHandler(OrderHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleOrder(String orderContent) {
		if (orderContent.lastIndexOf("Texas") != -1) {
			System.out.println("handle order for CompanyB from Texas");
		} 
	}
}
