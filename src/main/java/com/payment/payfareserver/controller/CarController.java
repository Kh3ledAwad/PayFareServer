package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.CarDTO;
import com.payment.payfareserver.entity.Car;
import com.payment.payfareserver.entity.Chairs;
import com.payment.payfareserver.service.*;
import com.payment.payfareserver.utilities.ScanData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private ChairsService chairsService;

    @GetMapping("/car")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
//    @GetMapping("/car/trips")
//    public List<Car> getAllTripsCar(@RequestParam("ownerId")int ownerId) {
//        Car car = carService.
//    }

    @RequestMapping(value = "/car/get-by-id", method = RequestMethod.GET)
    public Car getCarById(@RequestParam("id") int carId) {
        return carService.getCarById(carId);
    }

    @RequestMapping(value = "/car/chairsbyid", method = RequestMethod.GET)
    public List<Chairs> getChairsCarById(@RequestParam("id") int carId) {
        Car car = carService.getCarById(carId);
        return car.getChairs();
    }

    @RequestMapping(value = "/car/chairs", method = RequestMethod.GET)
    public List<Chairs> getChairsCarByQr(@RequestParam("qrcode") String carQrCode) {
        Car car = carService.getCarByQrCode(carQrCode);
        return car.getChairs();
    }

    @PutMapping("/car/chairsRest")
    public Boolean chairsRest(@RequestParam("id") int carId) {
        Car car = carService.getCarById(carId);
        List<Chairs> allChairs = car.getChairs();
        for (Chairs chairs : allChairs) {
            chairs.setStatus(0);
            chairsService.save(chairs);
        }
        return true;
    }

    @RequestMapping(value = "/car/get-by-station", method = RequestMethod.GET)
    public Car getCarByMainStationId(@RequestParam("id") int carId, @RequestParam("station_id") int stationId) {
        return carService.getCarByMainStationId(carId, stationId);
    }

    @RequestMapping(value = "/car/get-by-car-code", method = RequestMethod.GET)
    public Car getCarByCarCode(@RequestParam("car_code") String carCode) {
        return carService.getCarByCarCode(carCode);
    }

    @RequestMapping(value = "/car/tripPrice", method = RequestMethod.GET)
    public double getCarTripPrice(@RequestParam("qrcode") String carQr) {
        Car car = carService.getCarByQrCode(carQr);
        return car.getTraffic().getPrice();
    }

    @GetMapping("/car/scan")
    public ResponseEntity<ScanData> getData(@RequestParam("qrcode") String qrCode) {
        Car car = carService.getCarByQrCode(qrCode);
        int carId = car.getId();
        double price = car.getTraffic().getPrice();
       String driverPhone = car.getDriver().getUser().getPhone();
       ScanData response;
        return new ResponseEntity<>(new ScanData(carId,price,driverPhone), HttpStatus.OK);
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
        carService.save(car);

        for (int i = 1; i <= carDTO.getCarCapacity(); i++) {
            Chairs chair = new Chairs();
            chair.setCar(car);
            chair.setChairNumber(i);
            chair.setStatus(0);
            chairsService.save(chair);
        }
        return car;
    }
}