package learn.spring.rest.resources.asm;

import learn.spring.rest.controllers.AccountController;
import learn.spring.rest.model.Account;
import learn.spring.rest.resources.AccountResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class AccountResourceAssembler extends ResourceAssemblerSupport<Account, AccountResource> {
    public AccountResourceAssembler() {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account) {
        AccountResource res = new AccountResource();
        res.setName(account.getName());
        res.setPassword(account.getPassword());
        res.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
        return res;
    }
}
