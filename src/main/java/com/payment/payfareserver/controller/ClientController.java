package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.ClientService;
import com.payment.payfareserver.Service.TypeService;
import com.payment.payfareserver.Service.UserService;
import com.payment.payfareserver.dto.ClientDTO;
import com.payment.payfareserver.entity.Client;
import com.payment.payfareserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;
    @GetMapping("/client/get-all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/client/get-by-id", method = RequestMethod.GET)
    public Client getClientById(@RequestParam("id") int clientId) {
        return clientService.getClientById(clientId);
    }

    @PostMapping("/client/save-client")
    public Client save(@RequestBody ClientDTO clientDTO) {
        Client client = new Client();
        User user = new User();
        user.setName(clientDTO.getUser().getName());
        user.setUserName(clientDTO.getUser().getUserName());
        user.setPassword(clientDTO.getUser().getPassword());
        user.setPhone(clientDTO.getUser().getPhone());
        user.setType (typeService.getTypeById(clientDTO.getUser().getType().getId()));
        client.setUser(userService.save(user));
        client.setWallet(clientDTO.getWallet());
        return clientService.save(client);
    }
// add

}