package controller;

import clients.entity.Client;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import repository.ClientsServices;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@RequestMapping("clients")
public class ClientsController {

    private ClientsServices clientsServices;

    public void setContactService(ClientsServices clientsServices) {
        this.clientsServices= clientsServices;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Client> list() {
        return clientsServices.findAll();
    }

    @RequestMapping(value="/{inn}", method = RequestMethod.GET)
    @ResponseBody
    public Client findById(@PathVariable long inn) {
        return clientsServices.findByInn(inn);
    }

}
