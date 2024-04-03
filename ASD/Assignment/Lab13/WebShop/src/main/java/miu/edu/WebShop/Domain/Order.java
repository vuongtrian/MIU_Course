package miu.edu.WebShop.Domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private List<OrderLine> orderlines = new LinkedList();
    private double totalPrice = 0.0D;
    private Customer customer;
    private int ordernumber;
    private Address billingAddress;
    private Address shippingAddress;
    private Payment payment;

    public Order(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public void computeTotalPrice() {
        this.totalPrice = 0.0D;

        OrderLine cartitem;
        for(Iterator iter = this.orderlines.iterator(); iter.hasNext(); this.totalPrice += (double)cartitem.getQuantity() * cartitem.getProduct().getPrice()) {
            cartitem = (OrderLine)iter.next();
        }

    }

    public void addOrderLine(OrderLine ol) {
        this.orderlines.add(ol);
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public List<OrderLine> getOrderlines() {
        return this.orderlines;
    }

    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrdernumber() {
        return this.ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String toString() {
        return "Order{orderlines=" + this.orderlines + ", totalPrice=" + this.totalPrice + ", customer=" + this.customer + ", ordernumber=" + this.ordernumber + ", billingAddress=" + this.billingAddress + ", shippingAddress=" + this.shippingAddress + ", payment=" + this.payment + "}";
    }
}
