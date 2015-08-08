package learn.spring.rest.controllers;

import java.util.List;

import learn.spring.rest.model.BlogEntry;
import learn.spring.rest.resources.BlogEntryResource;
import learn.spring.rest.resources.asm.BlogEntryResourceAssembler;
import learn.spring.rest.services.BlogEntryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {

	private BlogEntryService service;
	
	public BlogEntryController(BlogEntryService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(
			@PathVariable Long blogEntryId) {
		BlogEntry blogEntry = service.findBlogEntry(blogEntryId);
		if (blogEntry != null) {
			BlogEntryResource resource = new BlogEntryResourceAssembler()
					.toResource(blogEntry);
			return new ResponseEntity<BlogEntryResource>(resource,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<BlogEntry>> getBlogEntries() {
		if (service.getBlogEntries() != null
				&& service.getBlogEntries().size() > 0) {
			return new ResponseEntity<List<BlogEntry>>(
					service.getBlogEntries(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<BlogEntry>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<BlogEntryResource> addBlogEntry(
			@RequestBody BlogEntryResource blogEntryResource) {
		BlogEntry blogEntry = blogEntryResource.toBlogEntry();
		boolean inserted = service.insertBlogEntry(blogEntry);
		if (inserted) {
			BlogEntryResource resource = new BlogEntryResourceAssembler()
					.toResource(blogEntry);
			return new ResponseEntity<BlogEntryResource>(resource,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.DELETE)
	public ResponseEntity<BlogEntryResource> deleteBlogEntry(
			@PathVariable Long blogEntryId) {
		BlogEntry blogEntry = service.findBlogEntry(blogEntryId);
		boolean deleted = service.deleteBlogEntry(blogEntry);
		if (deleted) {
			BlogEntryResource res = new BlogEntryResourceAssembler()
					.toResource(blogEntry);
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.PUT)
	public ResponseEntity<BlogEntryResource> updateBlogEntry(
			@PathVariable Long blogEntryId,
			@RequestBody BlogEntryResource sentBlogEntry) {
		boolean updatedEntry = service.updateBlogEntry(sentBlogEntry.toBlogEntry());
		if (updatedEntry) {
			BlogEntryResource resource = new BlogEntryResourceAssembler()
					.toResource(sentBlogEntry.toBlogEntry());
			return new ResponseEntity<BlogEntryResource>(resource,
					HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}
	
//	part 1
//  similar to below, if object type is not returned, will still return a JSON
//	@RequestMapping(value="/testBlog")
//	public ResponseEntity<Object> test() {
//		BlogEntry blogEntry = new BlogEntry();
//		blogEntry.setTitle("Test Blog Entry");
//		
//		return new ResponseEntity<Object>(blogEntry, HttpStatus.OK);
//	}
	
//	part 2
//	@RequestMapping(value="/testBlog")
//	public @ResponseBody BlogEntry test() {
//		BlogEntry blogEntry = new BlogEntry();
//		blogEntry.setTitle("Test Blog Entry");
//		return blogEntry;
//	}
//	
//	@RequestMapping(value="/testBlog", method=RequestMethod.POST)
//	public @ResponseBody BlogEntry test(@RequestBody BlogEntry blogEntry) {
//		return blogEntry;
//	}
}
