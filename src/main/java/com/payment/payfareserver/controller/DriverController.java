package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.DriverDTO;
import com.payment.payfareserver.entity.Driver;
import com.payment.payfareserver.entity.User;
import com.payment.payfareserver.service.CarService;
import com.payment.payfareserver.service.DriverService;
import com.payment.payfareserver.service.TypeService;
import com.payment.payfareserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
public class DriverController {

    @Autowired
    private DriverService driverService;
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CarService carService;

    @GetMapping("/driver")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @RequestMapping(value = "/driver/get-by-id", method = RequestMethod.GET)
    public Driver getDriverById(@RequestParam("id") int driverId) {
        return driverService.getDriverById(driverId);
    }

    @RequestMapping(value = "/driver/get-by-user-id", method = RequestMethod.GET)
    public Driver getDriverByUserId(@RequestParam("id") int userId) {
        return driverService.getDriverByUserId(userId);
    }

    @RequestMapping(value = "/driver/get-by-driver-code", method = RequestMethod.GET)
    public Driver getDriverByDriverCode(@RequestParam("driver_code") String driverCode) {
        return driverService.getDriverByDriverCode(driverCode);
    }

    @RequestMapping(value = "/driver/phone", method = RequestMethod.GET)
    public Driver getDriverByDriverPhoneNumber(@RequestParam("phone") String phone) {
        return driverService.getDriverByUserPhone(phone);
    }

    @PostMapping("/driver")
    public Driver save(@RequestBody DriverDTO driverDTO) {
        Random rand = new Random();
        int maxNumber = 1000000000;
        Integer randomNumber = rand.nextInt(maxNumber) + 1;
        Driver driver = new Driver();
        User user = new User();
        user.setName(driverDTO.getUser().getName());
        user.setUserName(driverDTO.getUser().getUserName());
        user.setPassword(driverDTO.getLiceNum());
        user.setPhone(driverDTO.getUser().getPhone());
        user.setType(typeService.getTypeById(2));
        driver.setUser(userService.save(user));
        driver.setDriverCode(randomNumber.toString());
        driver.setLiceNum(driverDTO.getLiceNum());
        driver.setAmount(0.00);
        driver.setCar(carService.getCarById(driverDTO.getCar().getId()));
        driver.setStatus(0);
        return driverService.save(driver);
    }
//    @PutMapping("/driver/acceptAmount")
//    public String TransAmount(@RequestParam("id") int clientId,@RequestParam("phone") String phone,@RequestParam("amount") double amount) {
//
//    }
}