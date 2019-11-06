package controller;

import AOP.ExecutionTimeAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;
import service.AccountService;


@Controller
@RequestMapping("amount")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/{inn}", method = RequestMethod.GET)
    @ResponseBody
    @ExecutionTimeAnno
    public double getSumByInn(@PathVariable long inn) {
        return accountService.getSumByInn(inn);
    }


}
