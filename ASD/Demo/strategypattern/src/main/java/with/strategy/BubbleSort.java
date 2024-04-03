package with.strategy;

public class BubbleSort extends SortStrategy{
	public BubbleSort(ProductCollection productCollection) {
		super(productCollection);
	}

	@Override
	void sort() {
		System.out.println("perform bubblesort");
	}
}
