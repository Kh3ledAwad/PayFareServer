package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.StationService;
import com.payment.payfareserver.dto.StationDTO;
import com.payment.payfareserver.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/station/get-all")
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @RequestMapping(value = "/station/get-by-id", method = RequestMethod.GET)
    public Station getStationById(@RequestParam("id") int stationId) {
        return stationService.getStationById(stationId);
    }

    @PostMapping("/station/save-station")
    public Station save(@RequestBody StationDTO stationDTO) {
        Station station = new Station();
        return station;
    }


}