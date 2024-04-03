package miu.edu;

public class CartLine {
    private int quantity;
    private Product product;

    public CartLine(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double calPrice() {
       return product.getPrice() * quantity;
    }
}
