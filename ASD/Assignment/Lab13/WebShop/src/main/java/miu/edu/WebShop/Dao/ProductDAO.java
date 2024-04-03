package miu.edu.WebShop.Dao;

import miu.edu.WebShop.Domain.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDAO {
    private Map<Integer, Product> products = new HashMap();

    public void save(Product product) {
        this.products.put(product.getProductNumber(), product);
    }

    public Product find(int productNumber) {
        return (Product)this.products.get(productNumber);
    }

    public void remove(int productNumber) {
        this.products.remove(productNumber);
    }
}
