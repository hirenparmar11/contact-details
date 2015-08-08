package learn.spring.rest.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import learn.spring.rest.model.BlogEntry;
import learn.spring.rest.services.BlogEntryService;

public class BlogEntryCacheService implements BlogEntryService {
	
	private Map<Long, BlogEntry> blogEntries;
	
	public BlogEntryCacheService() {
		blogEntries = new HashMap<Long, BlogEntry>();
	}
	
	@Override
	public List<BlogEntry> getBlogEntries() {
		return new ArrayList<BlogEntry>(blogEntries.values());
	}

	@Override
	public BlogEntry findBlogEntry(Long id) {
		return blogEntries.get(id);
	}
	
	@Override
	public boolean insertBlogEntry(BlogEntry blogEntry) {
		if(blogEntries.containsKey(blogEntry.getId())) {
			return false;
		} else {
			blogEntries.put(blogEntry.getId(), blogEntry);
			return true;
		}
	}
	
	@Override
	public boolean updateBlogEntry(BlogEntry blogEntry) {
		if(blogEntries.containsKey(blogEntry.getId())) {
			blogEntries.put(blogEntry.getId(), blogEntry);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteBlogEntry(BlogEntry blogEntry) {
		if(blogEntries.containsKey(blogEntry.getId())) {
			blogEntries.remove(blogEntry.getId());
			return true;
		}
		return false;
	}

}
