package miu.edu.WebShop.Service;

import miu.edu.WebShop.Dao.OrderDAO;
import miu.edu.WebShop.Domain.CartItem;
import miu.edu.WebShop.Domain.Order;
import miu.edu.WebShop.Domain.OrderLine;
import miu.edu.WebShop.Domain.ShoppingCart;
import miu.edu.WebShop.Itegration.EmailSenderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private EmailSenderEvent emailSender;

    public OrderService() {
    }

    public void createOrder(ShoppingCart shoppingCart, int ordernumber) {
        Order order = new Order(ordernumber);
        Iterator var4 = shoppingCart.getCartlist().iterator();

        while(var4.hasNext()) {
            CartItem cartitem = (CartItem)var4.next();
            order.addOrderLine(new OrderLine(cartitem.getProduct(), cartitem.getQuantity()));
        }

        this.orderDAO.save(order);
    }

    public Order getOrder(int ordernumber) {
        return this.orderDAO.find(ordernumber);
    }

    public void saveOrder(Order order) {
        this.orderDAO.save(order);
    }

    public void placeOrder(int ordernumber) {
        Order order = this.getOrder(ordernumber);
        this.emailSender.sendEmail(order.getCustomer().getEmail(), "Thank for your order with ordernumber " + order.getOrdernumber());
    }
}
