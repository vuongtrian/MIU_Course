package with.templatemethod;

public class PaypalPayment extends Payment{
    private String paypalAddress;

    public PaypalPayment(Customer customer, String paypalAddress) {
        super(customer);
        this.paypalAddress = paypalAddress;
    }

    @Override
    protected void proceedPayment(double dollarAmount) {
        boolean validation = validate();
        if (validation) {
            // logic to perform paypal payment
            System.out.println("Perform payment with paypal address "+paypalAddress+" and amount $"+dollarAmount);

            // logic to notify customer
            System.out.println("Notify customer "+customer.getName()+" with email "+customer.getEmail()+" about paypal payment to address "+paypalAddress);
        }
    }

    @Override
    protected boolean validate() {
        System.out.println("Validate paypal address "+paypalAddress);
        return true;
    }
}
