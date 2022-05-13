package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {

    Station findStationById(int stationId);

    List<Station> findStationsByCityId(int cityId);

}