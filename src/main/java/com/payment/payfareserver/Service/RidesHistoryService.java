package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.RidesHistory;
import com.payment.payfareserver.repository.RidesHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RidesHistoryService {

    @Autowired
    private RidesHistoryRepository repository;

    public RidesHistory save(RidesHistory ridesHistory) {
        return repository.save(ridesHistory);
    }

    public List<RidesHistory> getAllRidesHistory() {
        List<RidesHistory> ridesHistory = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(ridesHistory::add);
        return ridesHistory;
    }
    public List<RidesHistory> getAllRidesHistoryByClientID(int clientId){
        return repository.findRidesHistoriesByClientId(clientId);
    }
    public RidesHistory getRidesHistoryById(int ridesHistoryId) {
        return repository.findRidesHistoryById(ridesHistoryId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}