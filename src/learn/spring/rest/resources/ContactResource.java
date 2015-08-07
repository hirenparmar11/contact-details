package learn.spring.rest.resources;

import learn.spring.rest.model.Contact;

import org.springframework.hateoas.ResourceSupport;

public class ContactResource extends ResourceSupport {

	private String name;
	private Long number;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	
	public Contact toContact() {
		Contact contact = new Contact();
		contact.setName(name);
		contact.setNumber(number);
		return contact;
	}
}
