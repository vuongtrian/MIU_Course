package miu.edu.WebShop.Service;

import miu.edu.WebShop.Dao.ShoppingDAO;
import miu.edu.WebShop.Domain.Product;
import miu.edu.WebShop.Domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingDAO shoppingDAO;

    public ShoppingService() {
    }

    public ShoppingCart getCart(int cartId) {
        return this.shoppingDAO.find(cartId);
    }

    public void createCart(int cartId) {
        ShoppingCart cart = new ShoppingCart(cartId);
        this.shoppingDAO.save(cart);
    }

    public void addToCart(int cartId, Product product, int quantity) {
        ShoppingCart cart = this.getCart(cartId);
        cart.addToCart(product, quantity);
        this.shoppingDAO.save(cart);
    }

    public void removeFromCart(int cartId, int productNumber, int quantity) {
        ShoppingCart cart = this.getCart(cartId);
        cart.removeFromCart(productNumber, quantity);
        this.shoppingDAO.save(cart);
    }

    public void changeQuantity(int cartId, int productNumber, int quantity) {
        ShoppingCart cart = this.getCart(cartId);
        cart.changeQuantity(productNumber, quantity);
        this.shoppingDAO.save(cart);
    }
}
