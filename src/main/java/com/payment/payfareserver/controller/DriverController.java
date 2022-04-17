package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.DriverService;
import com.payment.payfareserver.Service.TypeService;
import com.payment.payfareserver.Service.UserService;
import com.payment.payfareserver.dto.DriverDTO;
import com.payment.payfareserver.entity.Car;
import com.payment.payfareserver.entity.Driver;
import com.payment.payfareserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;

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
        User user = new User();
        user.setName(driverDTO.getUser().getName());
        user.setUserName(driverDTO.getUser().getUserName());
        user.setPassword(driverDTO.getUser().getPassword());
        user.setPhone(driverDTO.getUser().getPhone());
        user.setType(typeService.getTypeById(driverDTO.getUser().getType().getId()));
        driver.setUser(userService.save(user));
        driver.setDriverCode(driverDTO.getDriverCode());
        //driver.setDriverCode();
        driver.setLiceNum(driverDTO.getLiceNum());
        driver.setWallet(driverDTO.getWallet());
        return driverService.save(driver);
    }


}