package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.CityService;
import com.payment.payfareserver.Service.StateService;
import com.payment.payfareserver.dto.CityDTO;
import com.payment.payfareserver.entity.City;
import com.payment.payfareserver.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private StateService stateService;

    @GetMapping("/cityy")
    public List<City> getAllCitys() {
        return cityService.getAllCitys();
    }

    @PostMapping("/city")
    public City save(@RequestBody CityDTO cityDTO) {
        City city = new City();
        State state = new State();
        state.setStateNameAr(cityDTO.getState().getStateNameAr());
        state.setStateNameEn(cityDTO.getState().getStateNameEn());
        city.setCityNameAr(cityDTO.getCityNameAr());
        city.setCityNameEn(cityDTO.getCityNameEn());
        city.setState(stateService.save(state));
        return cityService.save(city);
    }

    @RequestMapping(value = "/city/get-by-id", method = RequestMethod.GET)
    public City getCityById(@RequestParam("id") int cityId) {
        return cityService.getCityById(cityId);
    }

    @RequestMapping(value = "/city/get-all-by-state-id", method = RequestMethod.GET)
    public List<City> getCitiesByStateId(@RequestParam("id") int stateId) {
        State state = stateService.getStateById(stateId);
        return cityService.getCitiesByStateId(state.getId());
    }

    @RequestMapping(value = "/city/get-by-name-arabic", method = RequestMethod.GET)
    public City getCityByNameAr(@RequestParam("cityNameAr") String cityNameAr) {
        return cityService.getCityByNameAr(cityNameAr);
    }

    @RequestMapping(value = "/city/get-by-name-english", method = RequestMethod.GET)
    public City getCityByNameEn(@RequestParam("cityNameEn") String cityNameEn) {
        return cityService.getCityByNameEn(cityNameEn);
    }
}