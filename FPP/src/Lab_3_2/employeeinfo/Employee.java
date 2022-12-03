package Lab_3_2.employeeinfo;

import Lab_3_2.AccountType;

import java.time.LocalDate;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;
	
	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire){
		this.name = name;
		this.hireDate = LocalDate.of(yearOfHire,monthOfHire,dayOfHire);
/* update, using LocalDate
		GregorianCalendar cal = new GregorianCalendar(yearOfHire,monthOfHire-1,dayOfHire);
		hireDate = cal.getTime();
*/
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void createNewChecking(double startAmount) {
		// implement
//		this.checkingAcct.setBalance(startAmount);
		checkingAcct = new Account(this, AccountType.checking, startAmount);
	}

	public void createNewSavings(double startAmount) {
		// implement
		this.savingsAcct = new Account(this, AccountType.savings, startAmount);
	}

	public void createNewRetirement(double startAmount) {
		// implement
		this.retirementAcct = new Account(this, AccountType.retirement, startAmount);
	}

	public String getFormattedAcctInfo() {
		// implement
		String res = "";
		if(this.savingsAcct != null) {
			res += this.savingsAcct.toString();
		}
		if (this.checkingAcct != null) {
			res += this.checkingAcct.toString();
		}
		if (this.retirementAcct != null) {
			res += this.retirementAcct.toString();
		}
		return "\nACCOUNT INFO FOR " + name + res + "\n";
	}
	public void deposit(String acctType, double amt){
		// implement
		if (acctType.equals(AccountType.savings.toString())) {
			savingsAcct.makeDeposit(amt);
		} else if (acctType.equals(AccountType.checking.toString())) {
			checkingAcct.makeDeposit(amt);
		} else if (acctType.equals(AccountType.retirement.toString())){
			retirementAcct.makeDeposit(amt);
		}
	}
	public boolean withdraw(String acctType, double amt){
		// implement
		if (acctType.equals(AccountType.savings.toString())) {
			savingsAcct.makeWithdrawal(amt);
			return true;
		} else if (acctType.equals(AccountType.checking.toString())) {
			checkingAcct.makeWithdrawal(amt);
			return true;
		} else if (acctType.equals(AccountType.retirement.toString())){
			retirementAcct.makeWithdrawal(amt);
			return true;
		}
		return false;
	}

}
