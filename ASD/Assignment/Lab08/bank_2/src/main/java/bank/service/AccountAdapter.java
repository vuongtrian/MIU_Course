package bank.service;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class AccountAdapter {
    public static AccountDTO convertFromAccountToAccountDTO (Account account) {
        AccountDTO dto = new AccountDTO(account.getAccountnumber());
        dto.setCustomer(account.getCustomer());
        dto.setEntryList(account.getEntryList());
        return dto;
    }

    public static Collection<AccountDTO> convertFromAccountListToAccountDTOList (Collection<Account> accountCollection) {
        Collection<AccountDTO> dtos = new ArrayList<>();
        for (Account a : accountCollection) {
            dtos.add(convertFromAccountToAccountDTO(a));
        }
        return dtos;
    }
}
