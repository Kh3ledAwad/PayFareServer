package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic, Integer> {

    Traffic findTrafficById(int trafficId);

    List<Traffic> findAllByStationId (int stationId);

}