package learn.spring.rest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import learn.spring.rest.model.Blog;
import learn.spring.rest.model.BlogEntry;
import learn.spring.rest.repositories.BlogEntryRepository;
import learn.spring.rest.repositories.BlogRepository;
import learn.spring.rest.services.BlogService;
import learn.spring.rest.services.exceptions.BlogNotFoundException;
import learn.spring.rest.services.util.BlogEntryList;
import learn.spring.rest.services.util.BlogList;

public class BlogServiceImpl implements BlogService {
	
	@Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogEntryRepository entryRepository;

	@Override
	public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
		Blog blog = blogRepository.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        BlogEntry entry = entryRepository.createBlogEntry(data);
        entry.setBlog(blog);
        return entry;
	}

	@Override
	public BlogList findAllBlogs() {
		return new BlogList(blogRepository.findAllBlogs());
	}

	@Override
	public BlogEntryList findAllBlogEntries(Long blogId) {
		Blog blog = blogRepository.findBlog(blogId);
        if(blog == null)
        {
            throw new BlogNotFoundException();
        }
        return new BlogEntryList(blogId, entryRepository.findByBlogId(blogId));
	}

	@Override
	public Blog findBlog(Long id) {
		return blogRepository.findBlog(id);
	}

}
