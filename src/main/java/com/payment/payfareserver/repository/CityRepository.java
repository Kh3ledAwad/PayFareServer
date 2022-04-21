package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    City findCityById(int cityId);

    //City findCityByIdUserId(int userId);
}