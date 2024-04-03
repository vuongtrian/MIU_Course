package miu.edu.WebShop.Domain;

public class CartItem {
    private int quantity;
    private Product product;

    public CartItem() {
    }

    public CartItem(Product product, int quantity) {
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
        return "Cartitem{quantity=" + this.quantity + ", product=" + this.product + "}";
    }
}
