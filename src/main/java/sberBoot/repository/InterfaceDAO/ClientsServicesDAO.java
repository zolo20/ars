package sberBoot.repository.InterfaceDAO;

import sberBoot.entity.ClientEntity;

import java.util.List;

public interface ClientsServicesDAO {

        void save(ClientEntity client);
        List<ClientEntity> findAll();
        ClientEntity findByInn(long id);
}
