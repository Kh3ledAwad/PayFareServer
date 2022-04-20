package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.CarService;
import com.payment.payfareserver.dto.CarDTO;
import com.payment.payfareserver.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car/get-all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/car/get-by-id", method = RequestMethod.GET)
    public Car getCarById(@RequestParam("id") int carId) {
        return carService.getCarById(carId);
    }

    @PostMapping("/car/save-car")
    public Car save(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        return car;
    }
//new 

}