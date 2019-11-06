package service;

import clients.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InterfaceDAO.ClientsServicesDAO;

import java.util.List;

@Service
public class ClientService {

    private ClientsServicesDAO clientsServicesDAO;

    @Autowired
    public ClientService(ClientsServicesDAO clientsServicesDAO) {
        this.clientsServicesDAO = clientsServicesDAO;
    }

    public List<Client> getAll() {
        return clientsServicesDAO.findAll();
    }

    public Client getByInn(long inn) {
        return clientsServicesDAO.findByInn(inn);
    }

}
