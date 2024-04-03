package with.templatemethod;

public class VisaPayment extends Payment{
    private VisaCard visaCard;

    public VisaPayment(Customer customer, VisaCard visaCard) {
        super(customer);
        this.visaCard = visaCard;
    }

    @Override
    protected void proceedPayment(double dollarAmount) {
        boolean validation = validate();
        if (validation) {
            // logic to perform payment visa card
            System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber()
                    + " and amount $" + dollarAmount);

            // logic to notify customer
            System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
                    + " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
        }
    }

    @Override
    protected boolean validate() {
        System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
        return true;
    }
}
