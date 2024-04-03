package bank.domain;

import java.util.*;


public class Account {
	long accountnumber;
	String type;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;

	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);

	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double addInterest() {
		double balance = getBalance();
		if(balance < 1000) {
			InterestStrategy interestStrategy = new LowInterestCalculator();
			return interestStrategy.calInterest(type, balance);
		} else if (balance > 1000 && balance < 5000) {
			InterestStrategy interestStrategy = new MiddleInterestCalculator();
			return interestStrategy.calInterest(type, balance);
		} else {
			InterestStrategy interestStrategy = new HighInterestCalculator();
			return interestStrategy.calInterest(type, balance);
		}
	}
}
