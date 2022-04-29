package com.payment.payfareserver.controller;

import com.payment.payfareserver.service.CityService;
import com.payment.payfareserver.service.StationService;
import com.payment.payfareserver.dto.StationDTO;
import com.payment.payfareserver.entity.City;
import com.payment.payfareserver.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StationController {

    @Autowired
    private StationService stationService;
    @Autowired
    private CityService cityService;

    @GetMapping("/station")
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @RequestMapping(value = "/station/get-by-id", method = RequestMethod.GET)
    public Station getStationById(@RequestParam("id") int stationId) {
        return stationService.getStationById(stationId);
    }

    @RequestMapping(value = "/station/get-by-city-id", method = RequestMethod.GET)
    public List<Station> getStationByCityId(@RequestParam("id") int cityId) {
        return stationService.getStationsByCityId(cityId);
    }

    @PostMapping("/station")
    public Station save(@RequestBody StationDTO stationDTO) {
        Station station = new Station();
        City city = cityService.getCityById(stationDTO.getCity().getId());
        station.setName(stationDTO.getName());
        station.setCity(city);
        return stationService.save(station);
    }
}