package repository;

import clients.entity.Client;

import java.util.List;

public interface ClientsServices {

        List<Client> findAll();
        Client findByInn(long id);
}
