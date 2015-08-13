package learn.spring.rest.services.impl;

import learn.spring.rest.model.BlogEntry;
import learn.spring.rest.repositories.BlogEntryRepository;
import learn.spring.rest.services.BlogEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {
	
	@Autowired
	private BlogEntryRepository blogEntryRepository;

	@Override
	public BlogEntry findBlogEntry(Long id) {
		return blogEntryRepository.findBlogEntry(id);
	}

	@Override
	public BlogEntry deleteBlogEntry(Long id) {
		return blogEntryRepository.deleteBlogEntry(id);
	}

	@Override
	public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
		return blogEntryRepository.updateBlogEntry(id, data);
	}

//	@Override
//	public BlogEntry createBlogEntry(BlogEntry data) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<BlogEntry> findByBlogId(Long blogId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
