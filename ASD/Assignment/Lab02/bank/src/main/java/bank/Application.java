package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();

		HistoryList historyList = new HistoryList();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
//		accountService.deposit(1263862, 240);
		DepositCommand depositCommand = new DepositCommand(accountService, 1263862, 240);
		depositCommand.execute();
		historyList.addCommand(depositCommand);

//		accountService.deposit(1263862, 529);
		depositCommand = new DepositCommand(accountService, 1263862, 529);
		depositCommand.execute();
		historyList.addCommand(depositCommand);

//		accountService.withdraw(1263862, 230);
		WithdrawCommand withdrawCommand = new WithdrawCommand(accountService, 1263862, 230);
		withdrawCommand.execute();
		historyList.addCommand(withdrawCommand);

		//use account 2;
//		accountService.deposit(4253892, 12450);
		depositCommand = new DepositCommand(accountService, 4253892, 12450);
		depositCommand.execute();
		historyList.addCommand(depositCommand);

//		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		TransferFundsCommand transferFundsCommand = new TransferFundsCommand(accountService,4253892, 1263862, 100, "payment of invoice 10232");
		transferFundsCommand.execute();
		historyList.addCommand(transferFundsCommand);

		// show balances
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


