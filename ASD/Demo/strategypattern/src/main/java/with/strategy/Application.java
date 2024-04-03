package with.strategy;

public class Application {

	public static void main(String[] args) {
		ProductCollection productCollection = new ProductCollection();
		SortStrategy sortStrategy = new BubbleSort(productCollection);
		productCollection.setSortStrategy(sortStrategy);
		productCollection.addproduct(new Product("A23", "Iphone 10"));
		productCollection.addproduct(new Product("A28", "Iphone 11"));
		productCollection.sort();
		
		SortStrategy newsortStrategy = new InsertionSort(productCollection);
		productCollection.setSortStrategy(newsortStrategy);
		productCollection.sort();
	}
}
