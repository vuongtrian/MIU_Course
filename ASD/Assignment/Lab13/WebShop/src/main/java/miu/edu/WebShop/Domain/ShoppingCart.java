package miu.edu.WebShop.Domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart {
    private int cartId;
    private List<CartItem> cartlist = new LinkedList();
    private double totalPrice = 0.0D;

    public ShoppingCart(int cartId) {
        this.cartId = cartId;
    }

    public void addToCart(Product product, int quantity) {
        boolean found = false;
        Iterator iter = this.cartlist.iterator();

        while(iter.hasNext()) {
            CartItem cartitem = (CartItem)iter.next();
            Product prod = cartitem.getProduct();
            if (prod.getProductNumber() == product.getProductNumber()) {
                cartitem.setQuantity(cartitem.getQuantity() + quantity);
                found = true;
                break;
            }
        }

        if (!found) {
            this.cartlist.add(new CartItem(product, quantity));
        }

        this.computeTotalPrice();
    }

    public void computeTotalPrice() {
        this.totalPrice = 0.0D;

        CartItem cartitem;
        for(Iterator iter = this.cartlist.iterator(); iter.hasNext(); this.totalPrice += (double)cartitem.getQuantity() * cartitem.getProduct().getPrice()) {
            cartitem = (CartItem)iter.next();
        }

    }

    public void removeFromCart(int productNumber, int quantity) {
        Iterator iter = this.cartlist.iterator();

        while(iter.hasNext()) {
            CartItem cartitem = (CartItem)iter.next();
            Product product = cartitem.getProduct();
            if (product.getProductNumber() == productNumber) {
                if (cartitem.getQuantity() <= quantity) {
                    iter.remove();
                    this.computeTotalPrice();
                    break;
                }

                cartitem.setQuantity(cartitem.getQuantity() - quantity);
            }
        }

    }

    public void changeQuantity(int productNumber, int quantity) {
        Iterator iter = this.cartlist.iterator();

        while(iter.hasNext()) {
            CartItem cartitem = (CartItem)iter.next();
            Product product = cartitem.getProduct();
            if (product.getProductNumber() == productNumber) {
                cartitem.setQuantity(quantity);
            }
        }

    }

    public void setCartlist(List<CartItem> cart) {
        this.cartlist = cart;
    }

    public List<CartItem> getCartlist() {
        return this.cartlist;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public int getCartId() {
        return this.cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String toString() {
        return "ShoppingCart{cartId=" + this.cartId + ", cartlist=" + this.cartlist + ", totalPrice=" + this.totalPrice + "}";
    }
}
