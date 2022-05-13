package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findCarById(int carId);

    List<Car> findCarsByOwnerId(int ownerId);

    Car findCarByCarCode(String carCode);

    List<Car> findCarsByMainStationId(int mainStationId);

    Car findCarByIdAndAndMainStationId(int carId,int mainStationId);
    List<Car> findCarsByTrafficId(int trafficId);

    Car findCarByQrCode(String qrCode);

}