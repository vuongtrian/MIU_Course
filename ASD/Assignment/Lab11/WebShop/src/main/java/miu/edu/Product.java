package miu.edu;

public class Product extends CatalogItem{
    private double price;

    public Product(String name, double price) {
        super(name);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
