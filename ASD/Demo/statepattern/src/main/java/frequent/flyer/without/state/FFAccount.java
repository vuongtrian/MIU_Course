package frequent.flyer.without.state;

public class FFAccount {
	private String accountNumber;
	private String accountType;
	private int numberOfMiles;
	private int numberOfFlights;

	public FFAccount(String aNumber, String accountType) {
		this.accountNumber = aNumber;
		this.accountType = accountType;
	}

	public void addFlight(int newMiles) {
		if (accountType.equals("silver")) {
			numberOfMiles += newMiles;
			numberOfFlights++;
			checkForUpgrade();
		} else {
			if (accountType.equals("gold")) {
				numberOfMiles += (2 * newMiles);
				numberOfFlights++;
				checkForUpgrade();
			} else {
				if (accountType.equals("platinum")) {
					numberOfMiles += (3 * newMiles);
					numberOfFlights++;
				}
			}
		}
	}

	public void checkForUpgrade() {
		if (accountType.equals("silver") && (numberOfMiles > 100000) || (numberOfFlights > 95)) {
			accountType = "gold";
			numberOfMiles += 5000;
		}
		if (accountType.equals("gold") && (numberOfMiles > 150000) || (numberOfFlights > 145)) {
			accountType = "platinum";
			numberOfMiles += 10000;
		}
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getNumberOfMiles() {
		return numberOfMiles;
	}

	public int getNumberOfFlights() {
		return numberOfFlights;
	}
	
	
}