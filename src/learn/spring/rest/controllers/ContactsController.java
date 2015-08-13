package learn.spring.rest.controllers;

import java.util.List;

import learn.spring.rest.model.Contact;
import learn.spring.rest.resources.ContactResource;
import learn.spring.rest.resources.asm.ContactResourceAssembler;
import learn.spring.rest.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/rest/contacts")
public class ContactsController {
	
	private ContactService service;
	
	@Autowired
	public ContactsController(ContactService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
	public ResponseEntity<ContactResource> getContact(
			@PathVariable Long contactId) {
		Contact contact = service.find(contactId);
		if (contact != null) {
			ContactResource resource = new ContactResourceAssembler()
					.toResource(contact);
			return new ResponseEntity<ContactResource>(resource,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<ContactResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> getContacts() {
		if (service.getContacts() != null
				&& service.getContacts().size() > 0) {
			return new ResponseEntity<List<Contact>>(
					service.getContacts(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Contact>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<ContactResource> addContact(
			@RequestBody ContactResource ContactResource) {
		Contact contact = ContactResource.toContact();
		boolean inserted = service.insert(contact);
		if (inserted) {
			ContactResource resource = new ContactResourceAssembler()
					.toResource(contact);
			return new ResponseEntity<ContactResource>(resource,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<ContactResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.DELETE)
	public ResponseEntity<ContactResource> deleteContact(
			@PathVariable Long contactId) {
		Contact contact = service.find(contactId);
		boolean deleted = service.delete(contact);
		if (deleted) {
			ContactResource res = new ContactResourceAssembler()
					.toResource(contact);
			return new ResponseEntity<ContactResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<ContactResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{contactId}", method = RequestMethod.PUT)
	public ResponseEntity<ContactResource> updateContact(
			@PathVariable Long contactId,
			@RequestBody ContactResource sentContact) {
		boolean updatedEntry = service.update(sentContact.toContact());
		if (updatedEntry) {
			ContactResource resource = new ContactResourceAssembler()
					.toResource(sentContact.toContact());
			return new ResponseEntity<ContactResource>(resource,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<ContactResource>(HttpStatus.NOT_FOUND);
		}
	}

//	@RequestMapping(value="/testContact")
//	public @ResponseBody Contact test() {
//		Contact contact = new Contact();
//		contact.setContactId(1L);
//		contact.setName("Hiren");
//		contact.setNumber(3392359454L);
//		return contact;
//	}
//	
//	@RequestMapping(value="/testContact", method=RequestMethod.POST)
//	public @ResponseBody Contact testPost(@RequestBody Contact contact) {
//		return contact;
//	}
}
