package learn.spring.rest.blog;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import learn.spring.rest.controllers.BlogEntryController;
import learn.spring.rest.model.BlogEntry;
import learn.spring.rest.services.BlogEntryService;

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

public class BlogEntryControllerTest {

	@InjectMocks
	private BlogEntryController controller;
	
	@Mock
	private BlogEntryService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
//	@Test
//	public void test() throws Exception {
//		mockMvc.perform(get("/testBlog")).andDo(print());
//		
//		mockMvc.perform(post("/testBlog")
//				.content("{\"title\":\"Lion King\"}")
//				.contentType(MediaType.APPLICATION_JSON)
//				).andExpect(jsonPath("$.title", is("Lion King")))
//				.andDo(print());
//	}
	
	@Test
	public void getExistingBlogEntry() throws Exception {
		BlogEntry blogEntry = new BlogEntry();
		blogEntry.setId(1L);
		blogEntry.setTitle("Test Title");
		
		when(service.findBlogEntry(1L)).thenReturn(blogEntry);
		
		mockMvc.perform(get("/rest/blog-entries/1"))
			.andDo(print())
			.andExpect(jsonPath("$.title", is(blogEntry.getTitle())))
			.andExpect(jsonPath("$.links[*].href", hasItem(Matchers.endsWith("/blog-entries/1"))))
			.andExpect(status().isOk());

	}
	
	@Test
	public void getNonExistingBlogEntry() throws Exception {		
		when(service.findBlogEntry(1L)).thenReturn(null);
		
		mockMvc.perform(get("/rest/blog-entries/1"))
			.andDo(print())
			.andExpect(status().isNotFound());

	}
	
//	@Test
//	public void getAllBlogEntries() throws Exception {
//		BlogEntry be1 = new BlogEntry();
//		be1.setId(1L);
//		be1.setTitle("Test Title 1");
//
//		BlogEntry be2 = new BlogEntry();
//		be2.setId(2L);
//		be2.setTitle("Test Title 2");
//		
//		BlogEntry be3 = new BlogEntry();
//		be3.setId(3L);
//		be3.setTitle("Test Title 3");
//
//		List<BlogEntry> blogEntries = new ArrayList<BlogEntry>();
//		blogEntries.add(be1);
//		blogEntries.add(be2);
//		blogEntries.add(be3);
//		
//		when(service.getBlogEntries()).thenReturn(blogEntries);
//		
//		mockMvc.perform(get("/rest/blog-entries/"))
//			.andDo(print())
//			.andExpect(jsonPath("$.[0].id", is(1)))
//			.andExpect(jsonPath("$.[0].title", is(blogEntries.get(0).getTitle())))
//			.andExpect(jsonPath("$.[1].id", is(2)))
//			.andExpect(jsonPath("$.[1].title", is(blogEntries.get(1).getTitle())))
//			.andExpect(jsonPath("$.[2].id", is(3)))
//			.andExpect(jsonPath("$.[2].title", is(blogEntries.get(2).getTitle())))			
//			.andExpect(status().isOk());
//
//	}
	
//	@Test
//	public void getEmptyBlogEntries() throws Exception {		
//		when(service.getBlogEntries()).thenReturn(new ArrayList<BlogEntry>());
//		
//		mockMvc.perform(get("/rest/blog-entries/"))
//			.andDo(print())
//			.andExpect(status().isNotFound());
//
//	}
//	
//	@Test
//    public void insertBlogEntry() throws Exception {
//        BlogEntry insertEntry = new BlogEntry();
//        insertEntry.setId(1L);
//        insertEntry.setTitle("Test Title");
//
//        service.insertBlogEntry(Mockito.any(BlogEntry.class));
//
//        mockMvc.perform(post("/rest/blog-entries/")
//                .content("{\"title\":\"Test Title\"}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(jsonPath("$.title", is(insertEntry.getTitle())))
//                .andExpect(jsonPath("$.links[*].href", hasItem(Mockito.endsWith("/blog-entries/"))))
//                .andExpect(status().isOk());
//    }
}
