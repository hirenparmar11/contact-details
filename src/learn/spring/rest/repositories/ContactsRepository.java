package learn.spring.rest.repositories;

import java.util.List;

import learn.spring.rest.model.Contact;

public interface ContactsRepository {

	public Contact find(Long id);

	public List<Contact> getContacts();

	public Contact insert(Contact contact);
	
	public Contact delete(Contact contact);

	public Contact update(Contact contact);
}
