package bank;

import bank.service.IAccountService;

public class TransferFundsCommand implements Command {
    private IAccountService accountService;
    private long fromAccountNumber;
    private long toAccountNumber;
    private double amount;
    private String description;

    public TransferFundsCommand(IAccountService accountService, long fromAccountNumber, long toAccountNumber, double amount, String description) {
        this.accountService = accountService;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
    }

    @Override
    public void unExecute() {
        accountService.transferFunds(toAccountNumber, fromAccountNumber, amount, description);
    }
}
