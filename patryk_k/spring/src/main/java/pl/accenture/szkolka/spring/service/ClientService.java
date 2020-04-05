package pl.accenture.szkolka.spring.service;

import org.springframework.stereotype.Service;
import pl.accenture.szkolka.spring.model.Client;
import pl.accenture.szkolka.spring.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClientsByName(String lastName){
        return new ArrayList<>(clientRepository.findAllByLastName(lastName));
    }

    public List<Client> getAllVipClients(int minimumToVip){
        return clientRepository.findAll()
                .stream()
                .filter(p->p.getOrders().size() >= minimumToVip)
                .collect(Collectors.toList());
    }

}
