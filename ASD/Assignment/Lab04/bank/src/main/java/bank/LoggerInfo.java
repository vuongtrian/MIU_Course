package bank;

import bank.domain.Account;
import bank.service.IAccountService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerInfo extends Observer{

    public LoggerInfo(IAccountService accountService) {
        super(accountService);
    }

    public void log(Account account) {
        Logger logger = Logger.getLogger(LoggerInfo.class.getName());
        logger.log(Level.INFO,"Account " + account.getAccountnumber() + " has changed!");
    }

    @Override
    public void update(Account account) {
        log(account);
    }
}
