package observer.pull;

public abstract class Observer {
	protected StockService stockService;

	public Observer(StockService stockService) {
		this.stockService = stockService;
	}


	public abstract void update();
}
