package com.payment.payfareserver.Service;

import com.payment.payfareserver.entity.Client;
import com.payment.payfareserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client update(Client client){
        return repository.save(client);
    }
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(clients::add);
        return clients;
    }

    public Client getClientById(int clientId) {
        return repository.findClientById(clientId);
    }
    public Client getClientByUserId(int userId){return repository.findClientByUserId(userId);}
    public int getCount() {
        return (int) repository.count();
    }

}