package miu.edu;

public class Order {
    private int orderNumber;
    private ShoppingCart shoppingCart;
    private OrderDAO orderDAO;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public double orderAmount() {
        int amount = 0;
        for (CartLine line : shoppingCart.getLineList()) {
            amount += (line.getQuantity() * line.getProduct().getPrice());
        }
        return amount;
    }
}
