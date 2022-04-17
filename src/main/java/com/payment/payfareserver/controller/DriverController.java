package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.DriverService;
import com.payment.payfareserver.dto.DriverDTO;
import com.payment.payfareserver.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/driver/get-all")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @RequestMapping(value = "/driver/get-by-id", method = RequestMethod.GET)
    public Driver getDriverById(@RequestParam("id") int driverId) {
        return driverService.getDriverById(driverId);
    }

    @PostMapping("/driver/save-driver")
    public Driver save(@RequestBody DriverDTO driverDTO) {
        Driver driver = new Driver();
        return driver;
    }


}