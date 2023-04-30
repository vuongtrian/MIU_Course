package accounts.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import accounts.domain.Account;
import accounts.repositories.AccountRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountsRepositoryTests {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private AccountRepository accountRepository;
 
    @Test
    public void whenFindByAccountHolder_thenReturnAccount() {
        // given
        Account account = new Account("123",0.0,"Frank Jones");
        entityManager.persist(account);
        entityManager.flush();
     
        // when
        Account found = accountRepository.findByAccountHolder("Frank Jones");
     
        // then
        assertThat(account.getAccountNumber())
          .isEqualTo(found.getAccountNumber());
        // and
        assertThat(account.getBalance())
        .isEqualTo(found.getBalance());
        // and
        assertThat(account.getAccountHolder())
        .isEqualTo(found.getAccountHolder());
    }
 
}