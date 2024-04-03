package miu.edu.WebShop.Domain;

public class CreditCardPayment implements IPaymentType{
    private String creditCardNumber;
    private String validationDate;
    private String creditCardType;

    public CreditCardPayment(String creditCardNumber, String validationDate, String creditCardType) {
        this.creditCardNumber = creditCardNumber;
        this.validationDate = validationDate;
        this.creditCardType = creditCardType;
    }

    public String toString() {
        return "CreditCardPayment{creditCardNumber='" + this.creditCardNumber + "', validationDate='" + this.validationDate + "', creditCardType='" + this.creditCardType + "'}";
    }
}
