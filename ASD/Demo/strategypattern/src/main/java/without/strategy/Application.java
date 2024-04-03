package without.strategy;

public class Application {

	public static void main(String[] args) {
		ProductCollection productCollection = new ProductCollection();
		productCollection.addproduct(new Product("A23", "Iphone 10"));
		productCollection.addproduct(new Product("A28", "Iphone 11"));
		productCollection.bubbleSort();
		productCollection.insertionSort();
	}
}
