package com.payment.payfareserver.Service;

import com.payment.payfareserver.entity.Station;
import com.payment.payfareserver.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository repository;

    public Station save(Station station) {
        return repository.save(station);
    }

    public List<Station> getAllStations() {
        List<Station> stations = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(stations::add);
        return stations;
    }

    public Station getStationById(int stationId) {
        return repository.findStationById(stationId);
    }

    public int getCount() {
        return (int) repository.count();
    }

    public Station getStationByUserId(int userId) {
        return repository.findStationUserId(userId);
    }
}