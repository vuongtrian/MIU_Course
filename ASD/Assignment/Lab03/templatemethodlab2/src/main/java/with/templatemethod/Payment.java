package with.templatemethod;

import without.templatemethod.VisaCard;

public abstract class Payment {

    protected Customer customer;

    public Payment(Customer customer) {
        this.customer = customer;
    }

    protected void proccessPayment(double amount, String currency) {
        double getAmount = calAmount(amount, currency);
        proceedPayment(getAmount);
        validate();
    }

    protected abstract void proceedPayment(double amount);
    protected abstract boolean validate();

    protected double calAmount(double amount, String currency) {
        double dollarAmount = amount;

        if (currency.contentEquals("EUR")) { // European Euro
            dollarAmount = amount * 1.1;
            System.out.println("Convert "+amount+" "+currency+" to US dollars");

        }
        if (currency.contentEquals("INR")) { // Indian Rupee
            dollarAmount = amount * 0.014;
            System.out.println("Convert "+amount+" "+currency+" to US dollars");

        }
        return dollarAmount;
    }
}
