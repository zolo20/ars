package sberBoot.repository.InterfaceDAO;

import sberBoot.entity.AccountEntity;

import java.util.List;

public interface AccountServicesDAO {

    void save(AccountEntity accountEntity);
    List<AccountEntity> findAll();
    List<AccountEntity> findByInn(long  inn);
    double getAmountSumByInn(long inn);
}
