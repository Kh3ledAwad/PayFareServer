package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Chairs;
import com.payment.payfareserver.repository.ChairsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChairsService {

    @Autowired
    private ChairsRepository repository;

    public Chairs save(Chairs chairs) {
        return repository.save(chairs);
    }

    public List<Chairs> getAllChairs() {
        List<Chairs> chairss = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(chairss::add);
        return chairss;
    }

    public Chairs getChairsById(int chairsId) {
        return repository.findChairsById(chairsId);
    }

    public List<Chairs> getChairsByCarId(int carId) {
        return repository.findChairsByCarId(carId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}