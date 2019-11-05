package repository;

import clients.entity.Account;
import clients.entity.Client;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
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

    @RequestMapping(value="/{inn}", method = RequestMethod.GET)
    @ResponseBody
    public Client findByInn(@PathVariable long inn) {
        Optional <Client> optionalClient = clientsRepository.findById(inn);
        if (optionalClient.isPresent()) {
            return optionalClient.get();
        }
        return null;
    }

    @RequestMapping(value="/{inn}", method = RequestMethod.GET)
    @ResponseBody
    public double getBalanceSum(long id) {
        double sum = 0;
        Optional <Client> optionalClient = clientsRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client =  optionalClient.get();
            for ( Account account: client.getAccounts())
                sum += account.getBalance();
        }
        return sum;
    }

}
