package learn.spring.rest.blog.repositories;

import static org.junit.Assert.assertNotNull;
import learn.spring.rest.model.Account;
import learn.spring.rest.repositories.AccountRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:resources/spring/business-config.xml")
public class AccountRepositoryTest {
	
	@Autowired
	private AccountRepository repository;
	
	private Account account;
	
	@Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        account = new Account();
        account.setName("name");
        account.setPassword("password");
        repository.createAccount(account);
    }

	@Test
	public void test() {
		assertNotNull(repository.findAccount(account.getId()));
	}
}
