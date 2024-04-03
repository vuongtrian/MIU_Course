package without.strategy;

public class Product {
	private String productNumber;
	private String name;

	public Product(String productNumber, String name) {
		super();
		this.productNumber = productNumber;
		this.name = name;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
