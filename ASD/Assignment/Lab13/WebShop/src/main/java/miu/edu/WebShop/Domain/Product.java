package miu.edu.WebShop.Domain;

public class Product {
    private int productNumber;
    private String name;
    private double price;

    public Product(int productNumber, String name, double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public int getProductNumber() {
        return this.productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Product{productNumber=" + this.productNumber + ", name='" + this.name + "', price=" + this.price + "}";
    }
}
