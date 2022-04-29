package com.payment.payfareserver.controller;

import com.payment.payfareserver.service.CarService;
import com.payment.payfareserver.dto.CarDTO;
import com.payment.payfareserver.entity.Car;
import com.payment.payfareserver.service.OwnerService;
import com.payment.payfareserver.service.StationService;
import com.payment.payfareserver.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private StationService stationService;
    @Autowired
    private TrafficService trafficService;
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/car/get-by-id", method = RequestMethod.GET)
    public Car getCarById(@RequestParam("id") int carId) {
        return carService.getCarById(carId);
    }

    @PostMapping("/car")
    public Car save(@RequestBody CarDTO carDTO) {
        Random rand = new Random();
        int maxNumber = 10000000;
        Integer randomNumber = rand.nextInt(maxNumber) + 1;
        Car car = new Car();
        car.setCarCode(randomNumber.toString());
        car.setMainStation(stationService.getStationById(carDTO.getMainStation().getId()));
        car.setTraffic(trafficService.getTrafficById(carDTO.getTraffic().getId()));
        car.setOwner(ownerService.getOwnerById(carDTO.getOwner().getId()));
        car.setCarCapacity(carDTO.getCarCapacity());
        car.setQrCode(carDTO.getQrCode());
        car.setCarPlateNum(carDTO.getCarPlateNum());
        return carService.save(car);
    }

}