package prob2B;

import java.util.List;

public class Order {
    private int orderNum;
    private List<OrderLine> orderLines;

    public void addOrderLine() {
        OrderLine orderLine = new OrderLine(this);
    }

    public Order(int orderNum) {
        this.orderNum = orderNum;
    }
}
