package frequent.flyer.with.state;

public class Platinum extends AccountState {
	public Platinum(FFAccount account) {
		super(account);
	}

	public void addFlight(int newMiles) {
		account.setNumberOfMiles(account.getNumberOfMiles() + (3 * newMiles));
		account.setNumberOfFlights(account.getNumberOfFlights() * 2);
	}

	public String getAccountType() {
		return "Platinum";
	}
}