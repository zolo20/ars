package repository;

import clients.entity.Client;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class ClientsServicesImpl implements ClientsServices {

    private ClientsRepository clientsRepository;

    @Autowired
    public void setCourseRepository(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @Transactional(readOnly=true)
    public List<Client> findAll() {
        return Lists.newArrayList(clientsRepository.findAll());
    }

    public Client findByInn(long id) {
        Optional <Client> optionalClient = clientsRepository.findByInn(id);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        }
        return null;
    }

}
