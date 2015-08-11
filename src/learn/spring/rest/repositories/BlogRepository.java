package learn.spring.rest.repositories;

import java.util.List;

import learn.spring.rest.model.Blog;

public interface BlogRepository {
	public Blog createBlog(Blog data);
    public List<Blog> findAllBlogs();
    public Blog findBlog(Long id);
    public Blog findBlogByTitle(String title);
    public List<Blog> findBlogsByAccount(Long accountId);
}
