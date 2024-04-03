package observer.push.multiple.subjects;

public class StockMarketView implements StockMarketObserver{

	@Override
	public void update(boolean stockMarketOpen) {
		showStockMarket( stockMarketOpen);		
	}
	
	public void showStockMarket(boolean stockMarketOpen) {
		if (stockMarketOpen) {
			System.out.println("The stock market is open");
		}
		else {
			System.out.println("The stock market is closed");
		}
	}

}
