package miu.edu.WebShop.Dao;

import miu.edu.WebShop.Domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDAO {
    private Map<Integer, Order> orders = new HashMap();

    public void save(Order order) {
        this.orders.put(order.getOrdernumber(), order);
    }

    public Order find(int orderId) {
        return (Order)this.orders.get(orderId);
    }
}
