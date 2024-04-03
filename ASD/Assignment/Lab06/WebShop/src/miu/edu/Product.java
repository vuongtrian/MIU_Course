package miu.edu;

public class Product extends Catalog{

    public Product(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("Product name: " + name);
    }
}
