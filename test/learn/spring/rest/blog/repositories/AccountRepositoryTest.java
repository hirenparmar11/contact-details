package learn.spring.rest.blog.repositories;

import learn.spring.rest.repositories.AccountRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:resources/spring/business-config.xml")
public class AccountRepositoryTest {
	
	@Autowired
	private AccountRepository repository;

	@Test
	public void test() {
		// TODO Auto-generated method stub

	}
}
