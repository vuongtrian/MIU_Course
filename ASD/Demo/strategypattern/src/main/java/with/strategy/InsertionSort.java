package with.strategy;

public class InsertionSort extends SortStrategy{
	public InsertionSort(ProductCollection productCollection) {
		super(productCollection);
	}

	@Override
	void sort() {
		System.out.println("perform insertionsort");
	}
}