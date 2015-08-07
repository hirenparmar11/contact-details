package learn.spring.rest.contacts;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import learn.spring.rest.controllers.ContactsController;
import learn.spring.rest.model.Contact;
import learn.spring.rest.services.ContactService;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ContactsControllerTest {

	@InjectMocks
	private ContactsController controller;
	
	@Mock
	private ContactService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
//	@Test
//	public void test() throws Exception {
//		mockMvc.perform(get("/testContact")).andDo(print());
//		
//		mockMvc.perform(post("/testContact")
//				.content("{\"contactId\":\"2\", \"name\":\"Rupali\", \"number\":\"4243924847\"}")
//				.contentType(MediaType.APPLICATION_JSON)
//				).andExpect(jsonPath("$.contactId", Matchers.is(2)))
//				.andExpect(jsonPath("$.name", Matchers.is("Rupali")))
//				.andExpect(jsonPath("$.number", Matchers.is(4243924847L)))
//				.andDo(print());
//	}
	
	@Test
	public void getExistingContact() throws Exception {
		Contact contact = new Contact();
		contact.setContactId(1L);
		contact.setName("XYZ");
		contact.setNumber(1234567890L);
		
		when(service.find(1L)).thenReturn(contact);
		
		mockMvc.perform(get("/rest/contacts/1"))
			.andDo(print())
			.andExpect(jsonPath("$.name", is(contact.getName())))
			.andExpect(jsonPath("$.number", is(contact.getNumber())))
			.andExpect(jsonPath("$.links[*].href", hasItem(Matchers.endsWith("/contacts/1"))))
			.andExpect(status().isOk());

	}
	
	@Test
	public void getNonExistingContact() throws Exception {		
		when(service.find(1L)).thenReturn(null);
		
		mockMvc.perform(get("/rest/contacts/1"))
			.andDo(print())
			.andExpect(status().isNotFound());

	}
	
	@Test
	public void getAllBlogEntries() throws Exception {
		Contact c1 = new Contact();
		c1.setContactId(1L);
		c1.setName("XYZ");
		c1.setNumber(1234567890L);

		Contact c2 = new Contact();
		c2.setContactId(2L);
		c2.setName("ABC");
		c2.setNumber(1234567890L);
		
		Contact c3 = new Contact();
		c3.setContactId(3L);
		c3.setName("PQR");
		c3.setNumber(1234567890L);

		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		
		when(service.getContacts()).thenReturn(contacts);
		
		mockMvc.perform(get("/rest/contacts/"))
			.andDo(print())
			.andExpect(jsonPath("$.[0].contactId", is(1)))
			.andExpect(jsonPath("$.[0].name",is(contacts.get(0).getName())))
			.andExpect(jsonPath("$.[0].number", anyOf(is((Number) contacts.get(0).getNumber()), is((Number) contacts.get(0).getNumber().intValue()))))
			.andExpect(jsonPath("$.[1].contactId", is(2)))
			.andExpect(jsonPath("$.[1].name", is(contacts.get(1).getName())))
			.andExpect(jsonPath("$.[1].number", anyOf(is((Number) contacts.get(1).getNumber()), is((Number) contacts.get(1).getNumber().intValue()))))
			.andExpect(jsonPath("$.[2].contactId", is(3)))
			.andExpect(jsonPath("$.[2].name", is(contacts.get(2).getName())))	
			.andExpect(jsonPath("$.[2].number", anyOf(is((Number) contacts.get(2).getNumber()), is((Number) contacts.get(2).getNumber().intValue()))))
			.andExpect(status().isOk());

	}
	
	@Test
	public void getEmptyBlogEntries() throws Exception {		
		when(service.getContacts()).thenReturn(new ArrayList<Contact>());
		
		mockMvc.perform(get("/rest/contacts/"))
			.andDo(print())
			.andExpect(status().isNotFound());

	}
	
	@Test
    public void insertContact() throws Exception {
        Contact insertEntry = new Contact();
        insertEntry.setContactId(1L);
        insertEntry.setName("XYZ");
        insertEntry.setNumber(1234567890L);

        service.insert(Mockito.any(Contact.class));

        mockMvc.perform(post("/rest/contacts/")
                .content("{\"name\":\"XYZ\", \"number\":\"1234567890\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.name", is(insertEntry.getName())))
                .andExpect(jsonPath("$.number", is(insertEntry.getNumber())))
                .andExpect(jsonPath("$.links[*].href", hasItem(Mockito.endsWith("/contacts/"))))
                .andExpect(status().isOk());
    }

}
