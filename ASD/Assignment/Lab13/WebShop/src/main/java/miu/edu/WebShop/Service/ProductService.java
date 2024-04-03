package miu.edu.WebShop.Service;

import miu.edu.WebShop.Dao.ProductDAO;
import miu.edu.WebShop.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    public ProductService() {
    }

    public void addProduct(int productNumber, String name, double price) {
        this.productDAO.save(new Product(productNumber, name, price));
    }

    public Product getProduct(int productNumber) {
        return this.productDAO.find(productNumber);
    }

    public void removeProduct(int productNumber) {
        this.productDAO.remove(productNumber);
    }
}
