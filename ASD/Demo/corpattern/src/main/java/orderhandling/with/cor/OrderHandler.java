package orderhandling.with.cor;

public abstract class OrderHandler {
	protected OrderHandler nextHandler;
	
	
	public OrderHandler(OrderHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public OrderHandler getNextHandler() {
		return nextHandler;
	}
	public abstract void handleOrder(String orderContent);
}
