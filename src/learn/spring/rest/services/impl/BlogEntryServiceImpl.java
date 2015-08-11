package learn.spring.rest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import learn.spring.rest.model.BlogEntry;
import learn.spring.rest.repositories.BlogEntryRepository;
import learn.spring.rest.services.BlogEntryService;

public class BlogEntryServiceImpl implements BlogEntryService {
	
	@Autowired
	private BlogEntryRepository blogEntryRepository;

	@Override
	public BlogEntry findBlogEntry(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntry deleteBlogEntry(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogEntry createBlogEntry(BlogEntry data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogEntry> findByBlogId(Long blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
