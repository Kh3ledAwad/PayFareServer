package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Chairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChairsRepository extends JpaRepository<Chairs, Integer> {

    Chairs findChairsById(int chairsId);
    @Transactional
    @Modifying
    @Query("update Chairs c set c.status=1 where c.car.id=?1 and c.chairNumber=?2")
    void updateChairs(int carId, int chairNum);
    List<Chairs> findChairsByCarId(int carId);
}