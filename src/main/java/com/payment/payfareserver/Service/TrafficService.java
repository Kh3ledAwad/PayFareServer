package com.payment.payfareserver.Service;

import com.payment.payfareserver.entity.Traffic;
import com.payment.payfareserver.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrafficService {

    @Autowired
    private TrafficRepository repository;

    public Traffic save(Traffic traffic) {
        return repository.save(traffic);
    }

    public List<Traffic> getAllTraffics() {
        List<Traffic> traffics = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(traffics::add);
        return traffics;
    }

    public Traffic getTrafficById(int trafficId) {
        return repository.findTrafficById(trafficId);
    }

    public int getCount() {
        return (int) repository.count();
    }

    public Traffic getTrafficByUserId(int userId) {
        return repository.findTrafficUserId(userId);
    }
}