package Lab_3_1;

class Account {
//	public final static String CHECKING = "checking";
//	public final static String SAVINGS = "savings";
//	public final static String RETIREMENT = "retirement";
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType acctType;
	private Employee employee;

	Account(Employee emp, AccountType acctType, double balance) {
		employee = emp;
		this.acctType = acctType;
		this.balance = balance;
	}

	Account(Employee emp, AccountType acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getAcctType() {
		return acctType;
	}

	public void setAcctType(AccountType acctType) {
		this.acctType = acctType;
	}

	public String toString() {
		return "type = " + acctType + ", balance = " + balance;
	}

	//updates the balance
	public void makeDeposit(double deposit) {
		// implement
		if (deposit <= 0) {
			return;
		}
		balance += deposit;
	}

	//updates the balance field and returns true, unless
	//withdrawal amount is too large; in that case,
	//it does not modify the balance field, and returns false
	public boolean makeWithdrawal(double amount) {
		// implement
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			return true;
		}
		return false;
	}
}
