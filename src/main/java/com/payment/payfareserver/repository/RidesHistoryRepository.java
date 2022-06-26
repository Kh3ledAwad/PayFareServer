package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.RidesHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RidesHistoryRepository extends JpaRepository<RidesHistory, Integer> {

    RidesHistory findRidesHistoryById(int ridesHistoryId);

    List<RidesHistory> findRidesHistoriesByClientId(int clientId);
}