package observer.pull;

public class Trader extends Observer {

	public Trader(StockService stockService) {
		super(stockService);
	}


	public void trade(Stock stock) {
		System.out.println("Trader trade stock :" + stock);
	}


	@Override
	public void update() {
		Stock stock = stockService.getLastChangedStock();
		trade(stock);		
	}
}
