package miu.edu.WebShop.Domain;

public class OrderLine {
    private int quantity;
    private Product product;

    public OrderLine() {
    }

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return "Orderline{quantity=" + this.quantity + ", product=" + this.product + "}";
    }
}
