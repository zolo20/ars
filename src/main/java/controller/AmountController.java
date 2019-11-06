package controller;

import AOP.ExecutionTimeAnno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import clients.entity.Client;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import repository.ClientsServices;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Controller
@RequestMapping("amount")
public class AmountController implements ClientsServices {

    private final Logger logger = LoggerFactory.getLogger(AmountController.class);
    private ClientsServices clientsServices;

    public void setContactService(ClientsServices clientsServices) {
        this.clientsServices = clientsServices;
    }

    @RequestMapping(value = "/{inn}", method = RequestMethod.GET)
    @ResponseBody
    @ExecutionTimeAnno
    public double findById(@PathVariable long inn) {
        return clientsServices.getAmountSumByInn(inn);
    }

}
