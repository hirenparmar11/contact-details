package learn.spring.rest.services;

import java.util.List;

import learn.spring.rest.model.BlogEntry;

public interface BlogEntryService {

	public BlogEntry find(Long id);

	public List<BlogEntry> getBlogEntries();

	public boolean insert(BlogEntry blogEntry);
	
	public boolean delete(BlogEntry blogEntry);

	public boolean update(BlogEntry blogEntry);
}
