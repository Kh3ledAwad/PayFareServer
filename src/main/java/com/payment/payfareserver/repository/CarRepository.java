package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findCarById(int carId);


}