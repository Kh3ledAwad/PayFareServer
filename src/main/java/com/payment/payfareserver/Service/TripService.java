package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Trip;
import com.payment.payfareserver.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository repository;

    public Trip save(Trip trip) {
        return repository.save(trip);
    }

    public List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(trips::add);
        return trips;
    }

    public Trip getTripById(int tripId) {
        return repository.findTripById(tripId);
    }

    public List<Trip> getTripsByCar_OwnerId(int ownerId){return repository.findTripsByCar_OwnerId(ownerId);}
    public List<Trip> getTripsByCarId(int carId){
        return repository.findTripsByCarId(carId);
    }
    public int getCount() {
        return (int) repository.count();
    }

}