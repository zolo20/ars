package repository.InterfaceDAO;

import clients.entity.Client;

import java.util.List;

public interface ClientsServicesDAO {

        void save(Client client);
        List<Client> findAll();
        Client findByInn(long id);
}
