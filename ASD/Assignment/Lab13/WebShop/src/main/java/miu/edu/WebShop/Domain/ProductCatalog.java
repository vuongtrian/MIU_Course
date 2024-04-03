package miu.edu.WebShop.Domain;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> productList = new ArrayList<>();

    public ProductCatalog(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct (Product product) {
        productList.add(product);
    }

    public Product getProduct (int productNumber) {
        for (Product p : productList) {
            if (p.getProductNumber() == productNumber) {
                return p;
            }
        }
        return null;
    }

    public void removeProduct (int productNumber) {
        Product product = getProduct(productNumber);
        if (product == null) {
            System.out.println("Not found product");
        } else {
            productList.remove(product);
        }
    }

    @Override
    public String toString() {
        return "ProductCatalog{" +
                "productList=" + productList +
                '}';
    }
}
