package learn.spring.rest.repositories.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import learn.spring.rest.model.Account;
import learn.spring.rest.model.Blog;
import learn.spring.rest.repositories.AccountRepository;

@Repository
public class JPAAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}

	@Override
	public Account createAccount(Account data) {
		em.persist(data);
        return data;
	}

	@Override
	public Blog createBlog(Long accountId, Blog data) {
		// TODO Auto-generated method stub
		return null;
	}

}
