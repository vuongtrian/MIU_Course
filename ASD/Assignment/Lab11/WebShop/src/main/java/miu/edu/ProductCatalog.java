package miu.edu;

import java.util.ArrayList;
import java.util.Collection;

public class ProductCatalog extends CatalogItem{
    private Collection<CatalogItem> catalogItemCollection = new ArrayList<>();

    public ProductCatalog(String name) {
        super(name);
    }

    public void addProduct(CatalogItem item) {
        catalogItemCollection.add(item);
    }

    public void removeProduct (String productName) {
        for (CatalogItem item : catalogItemCollection) {
            if(item.getName().equals(productName)) {
                catalogItemCollection.remove(item);
            }
        }
    }

    public CatalogItem getProduct (String productName) {
        for (CatalogItem item : catalogItemCollection) {
            if(item.getName().equals(productName)) {
                return item;
            }
        }
        return null;
    }
}
