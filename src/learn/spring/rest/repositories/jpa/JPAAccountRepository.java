package learn.spring.rest.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import learn.spring.rest.model.Account;
import learn.spring.rest.repositories.AccountRepository;

import org.springframework.stereotype.Repository;

@Repository
public class JPAAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Account> findAllAccounts() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return query.getResultList();
    }

    @Override
    public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }

    @Override
    public Account findAccountByName(String name) {
        Query query = em.createQuery("SELECT a FROM Account a WHERE a.name=?1");
        query.setParameter(1, name);
        @SuppressWarnings("unchecked")
		List<Account> accounts = query.getResultList();
        if(accounts.size() == 0) {
            return null;
        } else {
            return accounts.get(0);
        }
    }

    @Override
    public Account createAccount(Account data) {
        em.persist(data);
        return data;
    }

}
