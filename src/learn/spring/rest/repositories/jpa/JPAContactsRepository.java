package learn.spring.rest.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import learn.spring.rest.model.Contact;
import learn.spring.rest.repositories.ContactsRepository;

@Repository
public class JPAContactsRepository implements ContactsRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Contact find(Long id) {
		Contact contact = em.find(Contact.class, id);
		if(contact == null) {
			return null;
		} else {
			return contact;
		}
	}

	@Override
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact insert(Contact contact) {
		em.persist(contact);
        return contact;
	}

	@Override
	public Contact delete(Contact contact) {
		em.remove(contact);
		return contact;
	}

	@Override
	public Contact update(Contact contact) {
		em.refresh(contact);
		return contact;
	}

}
