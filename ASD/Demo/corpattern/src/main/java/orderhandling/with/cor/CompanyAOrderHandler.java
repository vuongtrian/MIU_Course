package orderhandling.with.cor;

public class CompanyAOrderHandler extends OrderHandler{

	public CompanyAOrderHandler(OrderHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleOrder(String orderContent) {
		if (orderContent.startsWith("CompanyA")) {
			System.out.println("handle order for CompanyA");
		} else {
			nextHandler.handleOrder(orderContent);
		}
	}

}
