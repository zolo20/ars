package repository;

import clients.entity.Client;

import java.util.List;

public interface ClientsServices {
    Client findByInn (long inn);
    List <Client> findAll();
}
