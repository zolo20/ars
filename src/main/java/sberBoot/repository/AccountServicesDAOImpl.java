package sberBoot.repository;

import sberBoot.entity.AccountEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sberBoot.repository.InterfaceDAO.AccountServicesDAO;

import java.util.List;

@Repository
public class AccountServicesDAOImpl implements AccountServicesDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public AccountServicesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(AccountEntity accountEntity) {
        sessionFactory.getCurrentSession().save(accountEntity);
    }

    @Override
    public List<AccountEntity> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM AccountEntity").list();
    }

    @Override
    public List<AccountEntity> findByInn(long inn) {
        Query query =  sessionFactory.getCurrentSession()
                .createQuery("FROM ClientEntity WHERE inn = :inn");
        query.setParameter("inn", inn);
        return   query.list();
    }

    @Override
    public double getAmountSumByInn(long inn) {
        double sum = 0;
        List<AccountEntity> accountEntities =  findByInn(inn);
        for (AccountEntity accountEntity : accountEntities) {
            sum+= accountEntity.getBalance();
        }
        return sum;
    }
}
