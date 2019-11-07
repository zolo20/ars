package sberBoot.controller;

import sberBoot.AOP.ExecutionTimeAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sberBoot.entity.ClientEntity;
import sberBoot.service.ClientService;

import java.util.List;


@RestController
public class ClientsController {

    private ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value="clients", method = RequestMethod.GET)
    @ExecutionTimeAnno
    public List<ClientEntity> list() {
        return clientService.getAll();
    }

    @RequestMapping(value="clients/{inn}", method = RequestMethod.GET)
    @ExecutionTimeAnno
    public ClientEntity findById(@PathVariable long inn) {
        return clientService.getByInn(inn);
    }


}
