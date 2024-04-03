package miu.edu;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Categories categories1 = new Categories("Category 1");
        Categories categories2 = new Categories("Category 2");
        Categories categories3 = new Categories("Category 3");
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        Product product3 = new Product("Product 3");
        Product product4 = new Product("Product 4");
        Product product5 = new Product("Product 5");
        categories1.addItem(categories2);
        categories1.addItem(categories3);
        categories1.addItem(product4);
        categories2.addItem(product1);
        categories2.addItem(product2);
        categories2.addItem(product3);
        categories3.addItem(product5);
        categories1.print();
    }
}
