package sberBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sberBoot.entity.ClientEntity;
import sberBoot.repository.InterfaceDAO.ClientsServicesDAO;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ClientService {

    private ClientsServicesDAO clientsServicesDAO;

    @Autowired
    public ClientService(ClientsServicesDAO clientsServicesDAO) {
        this.clientsServicesDAO = clientsServicesDAO;
    }

    public List<ClientEntity> getAll() {
        return clientsServicesDAO.findAll();
    }

    public ClientEntity getByInn(long inn) {
        return clientsServicesDAO.findByInn(inn);
    }

    public ClientEntity save(@NotNull ClientEntity clientEntity) {
        clientsServicesDAO.save(clientEntity);
        return clientEntity;
    }

}
