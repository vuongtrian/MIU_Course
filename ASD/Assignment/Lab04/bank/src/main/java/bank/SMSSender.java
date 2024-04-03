package bank;

import bank.domain.Account;
import bank.service.IAccountService;

public class SMSSender extends Observer{

    public SMSSender(IAccountService accountService) {
        super(accountService);
    }

    public void send(Account account) {
        System.out.println("Sending SMS to " + account.getAccountnumber());
    }

    @Override
    public void update(Account account) {
        send(account);
    }
}
