package learn.spring.rest.repositories;

import java.util.List;

import learn.spring.rest.model.Account;
import learn.spring.rest.model.Blog;

public interface AccountRepository {
	
	public List<Account> findAllAccounts();
	public Account findAccount(Long id);
	public Account findAccountByName(String name);
	public Account createAccount(Account data);
}
