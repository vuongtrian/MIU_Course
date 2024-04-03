package webshop.order;

import framework.Autowired;
import framework.Service;
import webshop.shopping.Cartitem;
import webshop.shopping.ShoppingCart;


//@Service(name="MyOrderService")
@Service
public class OrderService {
    
	@Autowired
    OrderDAO orderDAO ;
	@Autowired
    EmailSender emailSender ;

    public void createOrder(ShoppingCart shoppingCart, int ordernumber){
        Order order = new Order(ordernumber);
        for (Cartitem cartitem: shoppingCart.getCartlist()){
            order.addOrderLine(new Orderline(cartitem.getProduct(), cartitem.getQuantity()));
        }
        orderDAO.save(order);
    }

    public Order getOrder(int ordernumber){
        return orderDAO.find(ordernumber);
    }

    public void saveOrder(Order order) {
        orderDAO.save(order);
    }

    public void placeOrder(int ordernumber) {
        Order order = getOrder(ordernumber);
        emailSender.sendEmail(order.getCustomer().getEmail(), "Thank for your webshop.order with ordernumber "+order.getOrdernumber());
    }
    
    public void print() {
    	System.out.println("@Service(name = OrderService)");
    }
}
