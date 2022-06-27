package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.ClientDTO;
import com.payment.payfareserver.entity.*;
import com.payment.payfareserver.service.*;
import com.payment.payfareserver.utilities.ClientTrips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private TripService tripService;
    @Autowired
    private RidesHistoryService ridesHistoryService;

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
        Trip currentTrip = tripService.getLastCarTrip(carId);
        RidesHistory ridesHistory = new RidesHistory();
        ridesHistory.setClient(clientService.getClientById(clientId));
        ridesHistory.setTrip(currentTrip);
        ridesHistory.setAmountPay(amount);
        ridesHistoryService.save(ridesHistory);
        return "Successful";
    }
    @GetMapping("/client/getRidesHistory")
    public ResponseEntity<List<ClientTrips>> getAllClientTrips(@RequestParam("id")int clientId){
        List<RidesHistory> historyList = ridesHistoryService.getAllRidesHistoryByClientID(clientId);
        List<ClientTrips>tripsList = new ArrayList<>();
        for(RidesHistory rs :historyList){
            int ridsHistoryId=rs.getId();
            String carPlateNum=rs.getTrip().getCar().getCarPlateNum();
            String driverPhone=rs.getTrip().getDriver().getUser().getPhone();
            Double amountPay=rs.getAmountPay();
            LocalDateTime date = rs.getTrip().getDate();
            tripsList.add(new ClientTrips(ridsHistoryId,carPlateNum,driverPhone,amountPay,date));
        }
       return new ResponseEntity<>(tripsList, HttpStatus.OK);

    }

}