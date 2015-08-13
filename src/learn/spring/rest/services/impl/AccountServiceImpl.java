package learn.spring.rest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import learn.spring.rest.model.Account;
import learn.spring.rest.model.Blog;
import learn.spring.rest.repositories.AccountRepository;
import learn.spring.rest.repositories.BlogRepository;
import learn.spring.rest.services.AccountService;
import learn.spring.rest.services.exceptions.AccountDoesNotExistException;
import learn.spring.rest.services.exceptions.AccountExistsException;
import learn.spring.rest.services.exceptions.BlogExistsException;
import learn.spring.rest.services.util.AccountList;
import learn.spring.rest.services.util.BlogList;

public class AccountServiceImpl implements AccountService {
	
	@Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BlogRepository blogRepository;

	@Override
	public Account findAccount(Long id) {
		return accountRepository.findAccount(id);
	}

	@Override
	public Account createAccount(Account data) {
		Account account = accountRepository.findAccountByName(data.getName());
        if(account != null)
        {
            throw new AccountExistsException();
        }
        return accountRepository.createAccount(data);
	}

	@Override
	public Blog createBlog(Long accountId, Blog data) {
		Blog blogSameTitle = blogRepository.findBlogByTitle(data.getTitle());

        if(blogSameTitle != null)
        {
            throw new BlogExistsException();
        }

        Account account = accountRepository.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }

        Blog createdBlog = blogRepository.createBlog(data);

        createdBlog.setOwner(account);

        return createdBlog;
	}

	@Override
	public BlogList findBlogsByAccount(Long accountId) {
		Account account = accountRepository.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }
        return new BlogList(blogRepository.findBlogsByAccount(accountId));
	}

	@Override
	public AccountList findAllAccounts() {
		return new AccountList(accountRepository.findAllAccounts());
	}

	@Override
	public Account findByAccountName(String name) {
		return accountRepository.findAccountByName(name);
	}

}
