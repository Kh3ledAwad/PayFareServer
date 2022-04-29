package com.payment.payfareserver.test.city;

import com.payment.payfareserver.service.CityService;
import com.payment.payfareserver.entity.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CityTest {
    @Autowired
    CityService cityService;

    @Test
    void getAllCity (){
        List <City> cityList = cityService.getAllCitys();
        for (City city : cityList){
            System.out.println(city.getCityNameAr());
            System.out.println(city.getCityNameEn());
            System.out.println("------------------");
        }

    }

}
