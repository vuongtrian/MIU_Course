package frequent.flyer.with.state;

public class FFAccount {
	private String accountNumber;
	private int numberOfMiles;
	private int numberOfFlights;
	private AccountState accountState;

	public FFAccount(String aNumber) {
		accountNumber = aNumber;
	}

	public void addFlight(int newMiles) {
		accountState.addFlight(newMiles);
	}
	
	public String getAccountType() {
		return accountState.getAccountType();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountState getAccountState() {
		return accountState;
	}

	public void setAccountState(AccountState accountState) {
		this.accountState = accountState;
	}

	public void setNumberOfMiles(int numberOfMiles) {
		this.numberOfMiles = numberOfMiles;
	}

	public void setNumberOfFlights(int numberOfFlights) {
		this.numberOfFlights = numberOfFlights;
	}

	public int getNumberOfMiles() {
		return numberOfMiles;
	}

	public int getNumberOfFlights() {
		return numberOfFlights;
	}

}