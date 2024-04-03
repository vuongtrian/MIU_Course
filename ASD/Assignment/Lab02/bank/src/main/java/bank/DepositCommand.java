package bank;

import bank.service.IAccountService;

public class DepositCommand implements Command{

    private IAccountService accountService;
    private long accountNumber;
    private double amount;

    public DepositCommand(IAccountService accountService, long accountNumber, double amount) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.deposit(accountNumber, amount);
    }

    @Override
    public void unExecute() {
        accountService.withdraw(accountNumber, amount);
    }
}
