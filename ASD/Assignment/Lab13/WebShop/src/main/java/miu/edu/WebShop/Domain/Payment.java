package miu.edu.WebShop.Domain;

public class Payment {
    private double amount;
    private String date;
    private IPaymentType paymentType;

    public Payment(double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public void setPaymentType(IPaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String toString() {
        return "Payment{amount=" + this.amount + ", date='" + this.date + "', paymentType=" + this.paymentType + "}";
    }
}
