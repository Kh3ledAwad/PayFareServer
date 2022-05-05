package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Car;
import com.payment.payfareserver.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public Car save(Car car) {
        return repository.save(car);
    }

    public Car update(Car car) {
        return repository.save(car);
    }

    public Boolean delete(int carId) {
        repository.deleteById(carId);
        return true;
    }

    public Car getCarByCarCode(String carCode) {

        return repository.findCarByCarCode(carCode);
    }

    public  List<Car> getCarByMainStationId(int mainStationId) {

        return repository.findCarByMainStationId(mainStationId);
    }

    public List<Car> getCarsByTrafficId(int trafficId) {
        return repository.findCarsByTrafficId(trafficId);
    }

    public Car getCarByQrCode(String qrCode) {
        return repository.findCarByQrCode(qrCode);
    }

    public List<Car> getCarsByOwnerId(int ownerId) {
        return repository.findCarsByOwnerId(ownerId);
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(cars::add);
        return cars;
    }

    public Car getCarById(int carId) {
        return repository.findCarById(carId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}