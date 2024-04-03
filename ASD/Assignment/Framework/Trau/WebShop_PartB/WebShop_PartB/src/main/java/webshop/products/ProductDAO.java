package webshop.products;

import java.util.HashMap;
import java.util.Map;

import framework.Service;

@Service
public class ProductDAO {
    private Map<Integer, Product> products = new HashMap<Integer, Product>();

    public void save(Product product){
        products.put(product.getProductNumber(), product);
    }

    public Product find(int productNumber){
        return products.get(productNumber);
    }

    public void remove(int productNumber){
        products.remove(productNumber);
    }
    
    public void print() {
    	System.out.println("@Service(name = ProductDAO)");
    }
}
