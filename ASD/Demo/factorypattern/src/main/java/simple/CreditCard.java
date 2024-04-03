package simple;

public class CreditCard {
	private String type;
	private String number;
	private double limit;
	private double annualCharge;
	
	public CreditCard(String type, String number, double limit, double annualCharge) {
		super();
		this.type = type;
		this.number = number;
		this.limit = limit;
		this.annualCharge = annualCharge;
	}
	
}
