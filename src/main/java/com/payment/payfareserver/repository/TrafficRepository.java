package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficRepository extends JpaRepository<Traffic, Integer> {

    Traffic findTrafficById(int trafficId);

   // Traffic findTrafficByIdUserId(int userId);
}