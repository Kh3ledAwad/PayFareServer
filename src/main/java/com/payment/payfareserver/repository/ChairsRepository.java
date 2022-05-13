package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Chairs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairsRepository extends JpaRepository<Chairs, Integer> {

    Chairs findChairsById(int chairsId);

    List<Chairs> findChairsByCarId(int carId);

}