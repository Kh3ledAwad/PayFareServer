package com.payment.payfareserver.Service;

import com.payment.payfareserver.entity.Driver;
import com.payment.payfareserver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    public Driver save(Driver driver) {
        return repository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(drivers::add);
        return drivers;
    }

    public Driver getDriverById(int driverId) {
        return repository.findDriverById(driverId);
    }

    public int getCount() {
        return (int) repository.count();
    }

    public Driver getDriverByUserId(int userId) {
        return repository.findDriverUserId(userId);
    }
}