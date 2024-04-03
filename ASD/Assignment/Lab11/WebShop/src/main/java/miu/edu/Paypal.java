package miu.edu;

public class Paypal extends PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Paying by paypal");
    }
}
