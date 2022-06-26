package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

    Driver findDriverById(int driverId);

    Driver findDriverByDriverCode(String driverCode);

    Driver findDriverByUserId(int userId);

    Driver findDriverByUserPhone(String phone);

    List<Driver> findDriversByStatus(int stu);
    @Transactional
    @Modifying
    @Query("update Driver d set d.status =?1 where d.id=?2")
    void changeDriverStatus(int value,int id);
}