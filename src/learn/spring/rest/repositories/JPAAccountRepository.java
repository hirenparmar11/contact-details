package learn.spring.rest.repositories;

import org.springframework.stereotype.Repository;

import learn.spring.rest.model.Account;
import learn.spring.rest.model.Blog;

@Repository
public class JPAAccountRepository implements AccountRepository {

	@Override
	public Account findAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account createAccount(Account data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog createBlog(Long accountId, Blog data) {
		// TODO Auto-generated method stub
		return null;
	}

}
