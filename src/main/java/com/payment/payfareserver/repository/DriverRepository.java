package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Car;
import com.payment.payfareserver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Driver findDriverById(int driverId);

    Driver findDriverByDriverCode(String driverCode);
    Driver findDriverByUserId(int userId);

    Driver findDriverByUserPhone(String phone);
}