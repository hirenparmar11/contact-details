package learn.spring.rest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import learn.spring.rest.model.Contact;
import learn.spring.rest.repositories.ContactsRepository;
import learn.spring.rest.services.ContactService;

@Service
@Transactional
public class ContactsServiceImp implements ContactService {

	@Autowired
	private ContactsRepository contactsRepository;
	
	@Override
	public Contact find(Long id) {
		return contactsRepository.find(id);
	}

	@Override
	public List<Contact> getContacts() {
		return contactsRepository.getContacts();
	}

	@Override
	public Contact insert(Contact contact) {
		return contactsRepository.insert(contact);
	}

	@Override
	public Contact delete(Contact contact) {
		return contactsRepository.delete(contact);
	}

	@Override
	public Contact update(Contact contact) {
		return contactsRepository.update(contact);
	}

}
