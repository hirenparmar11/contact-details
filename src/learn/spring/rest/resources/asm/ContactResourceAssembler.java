package learn.spring.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import learn.spring.rest.controllers.ContactsController;
import learn.spring.rest.model.Contact;
import learn.spring.rest.resources.ContactResource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ContactResourceAssembler extends
		ResourceAssemblerSupport<Contact, ContactResource> {

	public ContactResourceAssembler() {
		super(Contact.class, ContactResource.class);
	}

	@Override
	public ContactResource toResource(Contact contact) {
		ContactResource resource = new ContactResource();
		resource.setName(contact.getName());
		resource.setNumber(contact.getNumber());
		Link link = linkTo(
				methodOn(ContactsController.class).getContact(
						contact.getContactId())).withSelfRel();
		resource.add(link);
		return null;
	}
}
