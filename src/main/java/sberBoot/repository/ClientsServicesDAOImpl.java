package sberBoot.repository;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import sberBoot.entity.ClientEntity;
import sberBoot.repository.InterfaceDAO.ClientsServicesDAO;

import java.util.List;

@Repository
public class ClientsServicesDAOImpl implements ClientsServicesDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(ClientEntity client) {
        sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public List<ClientEntity> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM ClientEntity").list();
    }

    @Override
    public ClientEntity findByInn(long inn) {
        Query query =  sessionFactory.getCurrentSession()
                .createQuery("FROM ClientEntity WHERE inn = :inn");
        query.setParameter("inn", inn);
        return (ClientEntity) query.uniqueResult();
    }

}
