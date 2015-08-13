package learn.spring.rest.services;

import learn.spring.rest.model.Account;
import learn.spring.rest.model.Blog;
import learn.spring.rest.services.util.AccountList;
import learn.spring.rest.services.util.BlogList;

public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Blog createBlog(Long accountId, Blog data);
    public BlogList findBlogsByAccount(Long accountId);
    public AccountList findAllAccounts();
    public Account findByAccountName(String name);
}
