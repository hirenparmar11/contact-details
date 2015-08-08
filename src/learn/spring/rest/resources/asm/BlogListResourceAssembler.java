package learn.spring.rest.resources.asm;

import learn.spring.rest.controllers.BlogController;
import learn.spring.rest.resources.BlogListResource;
import learn.spring.rest.services.util.BlogList;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogListResourceAssembler extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAssembler()
    {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAssembler().toResources(blogList.getBlogs()));
        return res;
    }
}
