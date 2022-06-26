package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.BlockDTO;
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

    @RequestMapping(value = "/trip/get-by-owner_id", method = RequestMethod.GET)
    public List<Trip> getTripsByOwnerId(@RequestParam("id") int ownerId) {
        return tripService.getTripsByCar_OwnerId(ownerId);
    }

    @RequestMapping(value = "/trip/get-by-car_id", method = RequestMethod.GET)
    public List<Trip> getTripsByCarId(@RequestParam("carId") int carId) {
        return tripService.getTripsByCarId(carId);
    }

}