package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.ClientDTO;
import com.payment.payfareserver.entity.Client;
import com.payment.payfareserver.entity.Driver;
import com.payment.payfareserver.entity.User;
import com.payment.payfareserver.service.*;
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
    @Autowired
    private ChairsService chairsService;
    @Autowired
    private DriverService driverService;
    @GetMapping("/client")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/client/get-by-id", method = RequestMethod.GET)
    public Client getClientById(@RequestParam("id") int clientId) {
        return clientService.getClientById(clientId);
    }

    @RequestMapping(value = "/client/get-by-user-id", method = RequestMethod.GET)
    public Client getClientByUserId(@RequestParam("id") int userId) {
        return clientService.getClientByUserId(userId);
    }

    @PostMapping("/client")
    public Client save(@RequestBody ClientDTO clientDTO) {
        Client client = new Client();
        User user = new User();
        user.setName(clientDTO.getUser().getName());
        user.setUserName(clientDTO.getUser().getUserName());
        user.setPassword(clientDTO.getUser().getPassword());
        user.setPhone(clientDTO.getUser().getPhone());
        user.setType(typeService.getTypeById(3));
        client.setUser(userService.save(user));
        client.setAmount(0.00d);
        return clientService.save(client);
    }

    @PutMapping("/client")
    public Client update(@RequestBody ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        User user = userService.getUserById(clientDTO.getUser().getId());
        user.setName(clientDTO.getUser().getName());
        user.setUserName(clientDTO.getUser().getUserName());
        user.setPassword(clientDTO.getUser().getPassword());
        user.setPhone(clientDTO.getUser().getPhone());
        user.setType(typeService.getTypeById(clientDTO.getUser().getType().getId()));
        client.setUser(userService.save(user));
        return clientService.update(client);
    }

    @DeleteMapping("/client")
    public Boolean delete(@RequestParam("id") int clientId) {
        Client client = clientService.getClientById(clientId);
        User user = userService.getUserById(client.getUser().getId());
        clientService.delete(clientId);
        userService.delete(user.getId());
        return true;
    }

    @PutMapping("/client/addAmount")
    public String addAmount(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.getClientById(clientDTO.getId());
        double currentAmount = client.getAmount();
        Double amount = (currentAmount) + (clientDTO.getAmount());
        client.setId(clientDTO.getId());
        client.setAmount(amount);
        clientService.save(client);
        return "Successful";
    }
    @PutMapping("/client/transAmount")
    public String transAmount(@RequestParam("id") int clientId,@RequestParam("phone") String phone,@RequestParam("amount") double amount) {
        Client currentClient = clientService.getClientById(clientId);
        Client anotherClient = clientService.getClientByPhone(phone);
        if(currentClient.getAmount()<amount)
            return "Total amount not available";
        double cAmount = currentClient.getAmount()-amount;
        double aAmount = anotherClient.getAmount()+amount;
        currentClient.setAmount(cAmount);
        anotherClient.setAmount(aAmount);
        clientService.save(currentClient);
        clientService.save(anotherClient);
        return "Successful";
    }
    @PutMapping("/client/payfare")
     public String payFare(@RequestParam("clientId") int clientId, @RequestParam("carId") int carId
            ,@RequestParam("driverPhone") String phone, @RequestParam("amount") double amount, @RequestBody List<Integer> chairNumList){
        Client client = clientService.getClientById(clientId);
        Driver driver = driverService.getDriverByUserPhone(phone);
        double clientAmount = client.getAmount();
        if (clientAmount >= amount) {
            driverService.acceptAmount(driver.getAmount()+amount, driver.getId());
            clientService.updateWallet(amount, clientId);
        } else {
            return "Total amount not available";
        }
        for(int i :chairNumList){
            chairsService.updateChairsByCarIdAndAndChairNumber(carId,i);
        }
        return "Successful";
    }

}