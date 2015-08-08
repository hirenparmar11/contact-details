package learn.spring.rest.resources.asm;

import java.util.List;

import learn.spring.rest.controllers.BlogController;
import learn.spring.rest.resources.BlogEntryListResource;
import learn.spring.rest.resources.BlogEntryResource;
import learn.spring.rest.services.util.BlogEntryList;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogEntryListResourceAssembler extends ResourceAssemblerSupport<BlogEntryList, BlogEntryListResource> {
    public BlogEntryListResourceAssembler() {
        super(BlogController.class, BlogEntryListResource.class);
    }

    @Override
    public BlogEntryListResource toResource(BlogEntryList list) {
        List<BlogEntryResource> resources = new BlogEntryResourceAssembler().toResources(list.getEntries());
        BlogEntryListResource listResource = new BlogEntryListResource();
        listResource.setEntries(resources);
        listResource.add(linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel());
        return listResource;
    }
}
