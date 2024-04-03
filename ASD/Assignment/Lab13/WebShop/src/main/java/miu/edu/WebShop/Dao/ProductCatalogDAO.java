package miu.edu.WebShop.Dao;

import miu.edu.WebShop.Domain.ProductCatalog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductCatalogDAO {
    private int num;
    private Map<Integer, ProductCatalog> catalog = new HashMap<>();

    public void save (ProductCatalog productCatalog) {
        this.catalog.put(++num, productCatalog);
    }

    public ProductCatalog find (int num) {
        return (ProductCatalog) this.catalog.get(num);
    }
}
