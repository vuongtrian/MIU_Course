package observer.pull;

public class HistoryLogger extends Observer {

	public HistoryLogger(StockService stockService) {
		super(stockService);
	}

	public void log(Stock stock) {
		System.out.println("HistoryLogger log stock :" + stock);
	}

	@Override
	public void update() {
		Stock stock = stockService.getLastChangedStock();
		log(stock);
	}
}
