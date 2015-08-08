package learn.spring.rest.services;

import learn.spring.rest.model.Account;
import learn.spring.rest.model.Blog;

public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
}
