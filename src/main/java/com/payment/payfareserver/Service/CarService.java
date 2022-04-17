package com.payment.payfareserver.Service;

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

    public Car getCarByUserId(int userId) {
        return repository.findCarUserId(userId);
    }
}