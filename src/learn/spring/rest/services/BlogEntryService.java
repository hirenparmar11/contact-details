package learn.spring.rest.services;

import java.util.List;

import learn.spring.rest.model.BlogEntry;

public interface BlogEntryService {

	public BlogEntry findBlogEntry(Long id);
	public List<BlogEntry> getBlogEntries();
	public boolean insertBlogEntry(BlogEntry blogEntry);
	public boolean deleteBlogEntry(BlogEntry blogEntry);
	public boolean updateBlogEntry(BlogEntry blogEntry);
}
