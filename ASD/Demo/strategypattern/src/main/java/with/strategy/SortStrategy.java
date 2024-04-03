package with.strategy;

public abstract class SortStrategy {
	private ProductCollection productCollection;

	public SortStrategy(ProductCollection productCollection) {
		this.productCollection = productCollection;
	}

	abstract void sort();
}
