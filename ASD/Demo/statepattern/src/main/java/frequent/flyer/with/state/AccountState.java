package frequent.flyer.with.state;

public abstract class AccountState {
	protected final FFAccount account;

	public AccountState(FFAccount account) {
		this.account = account;
	}

	public abstract void addFlight(int newMiles);

	public abstract String getAccountType();
}
p