package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

    Trip findTripById(int tripId);
    List<Trip> findTripsByCar_OwnerId(int ownerId);

    List<Trip>findTripsByCarId(int carId);
}