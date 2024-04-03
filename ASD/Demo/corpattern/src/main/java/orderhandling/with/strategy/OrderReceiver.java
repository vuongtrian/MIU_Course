package orderhandling.with.strategy;

public class OrderReceiver {
	private OrderHandler orderHandler;
	
	public void setOrderHandler(OrderHandler orderHandler) {
		this.orderHandler = orderHandler;
	}

	public void handleOrder(String orderContent) {
		orderHandler.handleOrder(orderContent);
	}
}
