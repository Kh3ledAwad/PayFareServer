package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.BlockchainDTO;
import com.payment.payfareserver.dto.TripDTO;
import com.payment.payfareserver.entity.Blockchain;
import com.payment.payfareserver.entity.Trip;
import com.payment.payfareserver.service.*;
import com.payment.payfareserver.utilities.SHA256Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private TrafficService trafficService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private CarService carService;
    @Autowired
    private BlockchainService blockchainService;

    @GetMapping("/trip")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @RequestMapping(value = "/trip/get-by-id", method = RequestMethod.GET)
    public Trip getTripById(@RequestParam("id") int tripId) {
        return tripService.getTripById(tripId);
    }

    @PostMapping("/trip")
    public Trip save(@RequestBody TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setTraffic( trafficService.getTrafficById(tripDTO.getTraffic().getId()));
        trip.setAdmin(adminService.getAdminById(tripDTO.getAdmin().getId()));
        trip.setDriver(driverService.getDriverById(tripDTO.getDriver().getId()));
        trip.setCar( carService.getCarById(tripDTO.getCar().getId()));
        trip.setPrice(tripDTO.getPrice());

        Blockchain newBlock = new Blockchain();
        Blockchain oldBlock =blockchainService.getLastBlock();
        BlockchainDTO blockchainDto = new BlockchainDTO();
        blockchainDto.setData(SHA256Helper.randomString(20));
        if(blockchainService.getCount()==0) {
            blockchainDto.setPreviousHash("0000000000000000000000000000000000000000000000000000000000000000");
        }else{
            blockchainDto.setPreviousHash(oldBlock.getHash());
        }
        blockchainDto.generateHash();
        blockchainDto.setNonce(oldBlock.getNonce());
        blockchainDto.incrementNonce();
        newBlock.setHash(blockchainDto.getHash());
        newBlock.setPreviousHash(blockchainDto.getPreviousHash());
        newBlock.setNonce(blockchainDto.getNonce());
        newBlock.setTrip(tripService.save(trip));
        blockchainService.save(newBlock);
        return trip;
    }


}