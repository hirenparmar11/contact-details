package learn.spring.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import learn.spring.rest.controllers.BlogEntryController;
import learn.spring.rest.model.BlogEntry;
import learn.spring.rest.resources.BlogEntryResource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryResourceAssembler extends
		ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

	public BlogEntryResourceAssembler() {
		super(BlogEntryController.class, BlogEntryResource.class);
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource resource = new BlogEntryResource();
		resource.setTitle(blogEntry.getTitle());
		Link link = linkTo(
				methodOn(BlogEntryController.class).getBlogEntry(
						blogEntry.getId())).withSelfRel();
		resource.add(link.withSelfRel());
		return resource;
	}

}
