package bank.service;

import java.util.Collection;
import bank.domain.Account;

public interface IAccountService {
    Account createAccount(long accountNumber, String customerName);
    AccountDTO getAccount(long accountNumber);
    Collection<AccountDTO> getAllAccounts();
    void deposit (long accountNumber, double amount);
    void withdraw (long accountNumber, double amount);
    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
