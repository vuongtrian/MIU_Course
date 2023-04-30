package accounts.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class AccountServiceTests {
 
    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {
  
        @Bean
        public AccountService accountService() {
            return new AccountService();
        }
    }
 
    @Autowired
    private AccountService accountService;
 
    @MockBean
    private AccountRepository accountRepository;
 
    @Before
    public void setUp() {
    	Account account = new Account("123",0.0,"Frank Jones");
        Optional<Account> accountOptional= Optional.of(account); 
        Mockito.when(accountRepository.findById("123"))
          .thenReturn(accountOptional);
    }
    
    @Test
    public void whenValidAccountNumberThenAccountShouldBeFound() {
        AccountDTO found = accountService.getAccount("123");
      
         assertThat(found.getAccountNumber())
          .isEqualTo("123");
         assertThat(found.getAccountHolder())
         .isEqualTo("Frank Jones");
         assertThat(found.getBalance())
         .isEqualTo(0.0);
     }
}