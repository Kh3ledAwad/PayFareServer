package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.CityService;
import com.payment.payfareserver.dto.CityDTO;
import com.payment.payfareserver.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/get-all")
    public List<City> getAllCitys() {
        return cityService.getAllCitys();
    }

    @RequestMapping(value = "/city/get-by-id", method = RequestMethod.GET)
    public City getCityById(@RequestParam("id") int cityId) {
        return cityService.getCityById(cityId);
    }

    @PostMapping("/city/save-city")
    public City save(@RequestBody CityDTO cityDTO) {
        City city = new City();
        return city;
    }


}