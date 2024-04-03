package miu.edu;

public class CreditCard extends PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Paying by credit card");
    }
}
