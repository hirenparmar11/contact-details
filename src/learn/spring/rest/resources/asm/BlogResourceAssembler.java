package learn.spring.rest.resources.asm;

import learn.spring.rest.controllers.AccountController;
import learn.spring.rest.controllers.BlogController;
import learn.spring.rest.model.Blog;
import learn.spring.rest.resources.BlogResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogResourceAssembler extends ResourceAssemblerSupport<Blog, BlogResource> {
    public BlogResourceAssembler() {
        super(BlogController.class, BlogResource.class);
    }

    @Override
    public BlogResource toResource(Blog blog) {
        BlogResource resource = new BlogResource();
        resource.setTitle(blog.getTitle());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).withSelfRel());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).slash("entries").withRel("entries"));
        if(blog.getOwner() != null)
            resource.add(linkTo(AccountController.class).slash(blog.getOwner().getId()).withRel("owner"));
        return resource;
    }
}
