package pl.accenture.szkolka.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.accenture.szkolka.spring.model.Client;
import pl.accenture.szkolka.spring.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/lastname/{lastname}")
    public List<Client> getAllClientsByLastName(@PathVariable String lastname){
        return clientService.getAllClientsByName(lastname);
    }

    /**
     * Client is Vip when orders >= 2
     */
    @GetMapping("/clientvip")
    public List<Client> getAllVipClients(){
        return clientService.getAllVipClients(2);
    }

}
