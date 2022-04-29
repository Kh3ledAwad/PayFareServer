package com.payment.payfareserver.controller;

import com.payment.payfareserver.service.StationService;
import com.payment.payfareserver.service.TrafficService;
import com.payment.payfareserver.dto.TrafficDTO;
import com.payment.payfareserver.entity.Traffic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TrafficController {

    @Autowired
    private TrafficService trafficService;
    @Autowired
    private StationService stationService;

    @GetMapping("/traffic")
    public List<Traffic> getAllTraffics() {
        return trafficService.getAllTraffics();
    }

    @RequestMapping(value = "/traffic/get-by-id", method = RequestMethod.GET)
    public Traffic getTrafficById(@RequestParam("id") int trafficId) {
        return trafficService.getTrafficById(trafficId);
    }
    @RequestMapping(value = "/traffic/get-by-station-id", method = RequestMethod.GET)
    public List<Traffic> getTrafficByStationId(@RequestParam("id") int stationId) {
        return trafficService.getTrafficsByStationId(stationId);
    }

    @PostMapping("/traffic")
    public Traffic save(@RequestBody TrafficDTO trafficDTO) {
        Traffic traffic = new Traffic();
        traffic.setFrom(trafficDTO.getFrom());
        traffic.setTo(trafficDTO.getTo());
        traffic.setPrice(trafficDTO.getPrice());
        traffic.setStation(stationService.getStationById(trafficDTO.getStation().getId()));
        return trafficService.save(traffic);
    }

}