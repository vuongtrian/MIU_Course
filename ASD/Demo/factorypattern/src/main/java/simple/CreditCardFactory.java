package simple;

public class CreditCardFactory {
   static CreditCard getCreditCardInstance(String type, String number, double limit, double annualCharge) {
	   return new CreditCard(type, number, limit, annualCharge);
   }
}
