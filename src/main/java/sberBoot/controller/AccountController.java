package sberBoot.controller;

import lombok.NoArgsConstructor;
import sberBoot.AOP.ExecutionTimeAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sberBoot.service.AccountService;

@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "amount/{inn}", method = RequestMethod.GET)
    @ExecutionTimeAnno
    public double getSumByInn(@PathVariable long inn) {
        return accountService.getSumByInn(inn);
    }


}
