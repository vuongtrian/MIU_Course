package observer.java.buildin;

public class Stock {
	private String stockName;
	private double value;

	public Stock(String stockName, double value) {
		super();
		this.stockName = stockName;
		this.value = value;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Stock [stockName=" + stockName + ", value=" + value + "]";
	}

}
