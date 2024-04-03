package bank;

import bank.domain.Account;
import bank.service.IAccountService;

public class EmailSender extends Observer{

    public EmailSender(IAccountService accountService) {
        super(accountService);
    }

    public void send(Account account) {
        System.out.println("Sending email to " + account.getAccountnumber());
    }

    @Override
    public void update(Account account) {
        send(account);
    }
}
