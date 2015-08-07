package learn.spring.rest.services;

import java.util.List;

import learn.spring.rest.model.Contact;

public interface ContactService {

	public Contact find(Long id);

	public List<Contact> getContacts();

	public boolean insert(Contact contact);
	
	public boolean delete(Contact contact);

	public boolean update(Contact contact);
}
