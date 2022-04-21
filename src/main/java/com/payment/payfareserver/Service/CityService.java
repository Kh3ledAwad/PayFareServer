package com.payment.payfareserver.Service;

import com.payment.payfareserver.entity.City;
import com.payment.payfareserver.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public City save(City city) {
        return repository.save(city);
    }

    public List<City> getAllCitys() {
        List<City> citys = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(citys::add);
        return citys;
    }

    public City getCityById(int cityId) {
        return repository.findCityById(cityId);
    }
    public City getCityByNameAr(String cityNameAr){return repository.findCityByCityNameAr(cityNameAr);}
    public City getCityByNameEn(String cityNameEn){return repository.findCityByCityNameEn(cityNameEn);}

    public List<City>getCitiesByStateId(int stateId){return repository.findCitiesByStateId(stateId);}


    public int getCount() {
        return (int) repository.count();
    }

}