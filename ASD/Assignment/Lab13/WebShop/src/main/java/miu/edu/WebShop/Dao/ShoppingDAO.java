package miu.edu.WebShop.Dao;

import miu.edu.WebShop.Domain.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ShoppingDAO {
    private Map<Integer, ShoppingCart> shoppingCarts = new HashMap();

    public void save(ShoppingCart shoppingCart) {
        this.shoppingCarts.put(shoppingCart.getCartId(), shoppingCart);
    }

    public ShoppingCart find(int cartId) {
        return (ShoppingCart)this.shoppingCarts.get(cartId);
    }
}
