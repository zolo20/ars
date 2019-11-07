package sberBoot.service;

import sberBoot.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sberBoot.entity.ClientEntity;
import sberBoot.repository.InterfaceDAO.AccountServicesDAO;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class AccountService {

    private AccountServicesDAO accountServicesDAO;

    @Autowired
    public AccountService(AccountServicesDAO accountServicesDAO) {
        this.accountServicesDAO = accountServicesDAO;
    }

    public List<AccountEntity> getAll() {
        return accountServicesDAO.findAll();
    }

    public List<AccountEntity> getByInn(long inn) {
        return accountServicesDAO.findByInn(inn);
    }

    public double getSumByInn(long inn) {
        return accountServicesDAO.getAmountSumByInn(inn);
    }

    public AccountEntity save(@NotNull AccountEntity accountEntity) {
        accountServicesDAO.save(accountEntity);
        return accountEntity;
    }
}
