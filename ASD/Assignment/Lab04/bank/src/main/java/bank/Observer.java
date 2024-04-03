package bank;

import bank.domain.Account;
import bank.service.IAccountService;

public abstract class Observer {

    private IAccountService accountService;

    public Observer(IAccountService accountService) {
        this.accountService = accountService;
    }

    public abstract void update(Account account);
}
