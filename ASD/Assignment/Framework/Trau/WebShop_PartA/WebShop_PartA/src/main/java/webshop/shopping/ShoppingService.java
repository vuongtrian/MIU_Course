package webshop.shopping;


import framework.Autowired;
import framework.Service;
import webshop.products.Product;


//@Service(name="MyShoppingService")
@Service
public class ShoppingService {
    
	@Autowired
    ShoppingDAO shoppingDAO ;

    public ShoppingCart getCart(int cartId){
        return shoppingDAO.find(cartId);
    }

    public void createCart(int cartId){
        ShoppingCart cart = new ShoppingCart(cartId);
        shoppingDAO.save(cart);
    }

    public void addToCart(int cartId, Product product, int quantity){
        ShoppingCart cart = getCart(cartId);
        cart.addToCart(product, quantity);
        shoppingDAO.save(cart);
    }

    public void removeFromCart(int cartId, int productNumber, int quantity){
        ShoppingCart cart = getCart(cartId);
        cart.removeFromCart(productNumber, quantity);
        shoppingDAO.save(cart);
    }

    public void changeQuantity(int cartId, int productNumber, int quantity){
        ShoppingCart cart = getCart(cartId);
        cart.changeQuantity(productNumber, quantity);
        shoppingDAO.save(cart);
    }

    public void print() {
    	System.out.println("@Service(name = ShoppingService)");
    }

}
