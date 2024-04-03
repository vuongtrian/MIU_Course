package bank.service;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.LoggingProxy;
import bank.StopWatchProxy;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private ClassLoader classLoader;
	private IAccountDAO loggingProxy;
	private IAccountDAO stopwatchProxy;

	public AccountService(){
		accountDAO = new AccountDAO();
		classLoader = IAccountDAO.class.getClassLoader();
		loggingProxy =
				(IAccountDAO) Proxy.newProxyInstance(classLoader,
						new Class[] { IAccountDAO.class },
						new LoggingProxy(accountDAO));
		stopwatchProxy =
				(IAccountDAO) Proxy.newProxyInstance(classLoader,
						new Class[] { IAccountDAO.class },
						new StopWatchProxy(loggingProxy));
	}




	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		stopwatchProxy.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = stopwatchProxy.loadAccount(accountNumber);
		account.deposit(amount);
		stopwatchProxy.updateAccount(account);
	}

//	public Account getAccount(long accountNumber) {
//		Account account = stopwatchProxy.loadAccount(accountNumber);
//		return account;
//	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = stopwatchProxy.loadAccount(accountNumber);
		return AccountAdapter.convertFromAccountToAccountDTO(account);
	}

//	public Collection<Account> getAllAccounts() {
//		return accountDAO.getAccounts();
//	}

	public Collection<AccountDTO> getAllAccounts() {
		return AccountAdapter.convertFromAccountListToAccountDTOList(accountDAO.getAccounts());
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = stopwatchProxy.loadAccount(accountNumber);
		account.withdraw(amount);
		stopwatchProxy.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = stopwatchProxy.loadAccount(fromAccountNumber);
		Account toAccount = stopwatchProxy.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		stopwatchProxy.updateAccount(fromAccount);
		stopwatchProxy.updateAccount(toAccount);
	}
}
