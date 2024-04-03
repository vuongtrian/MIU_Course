package miu.edu;

public class Main {

    public static void main(String[] args) {
        Product iphone = new Product("Iphone", 500);
        Product samsung = new Product("Samsung", 450);
        ProductCatalog productCatalog = new ProductCatalog("Cellphone");
        productCatalog.addProduct(iphone);
        productCatalog.addProduct(samsung);

        ShoppingCart shoppingCart = new ShoppingCart(1);
        CartLine line1 = new CartLine(1);
        line1.setProduct(samsung);
        CartLine line2 = new CartLine(2);
        line1.setProduct(iphone);
        shoppingCart.addLine(line1);
        shoppingCart.addLine(line2);

        Order order = new Order(123);
        order.setShoppingCart(shoppingCart);

        Payment payment = new Payment();
        payment.setAmount(order.orderAmount());
        payment.setDate("2023-7-11");
        payment.setCreditCardNumber(1234566);
        payment.setValidationDate("2023-7-11");
        payment.setCreditCardType("Master");
        payment.setCustomer(new Customer("An", "an@gmail.com", "123456567"));
        payment.setBillingAddress(new Address("414 N B", "Fairfield", "Iowa"));
        payment.setShippingAddress(new Address("414 N B", "Fairfield", "Iowa"));
        payment.setPaymentStrategy(new CreditCard());

    }
}
