package with.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCollection {
	private List<Product> products = new ArrayList<Product>();
	private SortStrategy sortStrategy;
	
	public void addproduct(Product product) {
		products.add(product);
	}
	
	public boolean removeProduct(String productNumber) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getProductNumber().contentEquals(productNumber)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	
	public void sort() {
		sortStrategy.sort();
	}
	

	public void setSortStrategy(SortStrategy sortStrategy) {
		this.sortStrategy=sortStrategy;		
	}
}
