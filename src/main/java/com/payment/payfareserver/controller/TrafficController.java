package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.TrafficDTO;
import com.payment.payfareserver.entity.Car;
import com.payment.payfareserver.entity.Traffic;
import com.payment.payfareserver.service.StationService;
import com.payment.payfareserver.service.TrafficService;
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
    @RequestMapping(value = "/traffic/cars", method = RequestMethod.GET)
    public List<Car> getCarByTrafficId(@RequestParam("traffic_id") int trafficId) {
        Traffic traffic = trafficService.getTrafficById(trafficId);
        return traffic.getCars();
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
    @PutMapping("traffic/update-price")
    public Traffic updatePrice(@RequestBody TrafficDTO trafficDTO){
         Traffic traffic = trafficService.getTrafficById(trafficDTO.getId());
          traffic.setPrice(trafficDTO.getPrice());
          traffic.setTo(traffic.getTo());
          traffic.setFrom(traffic.getFrom());
          return trafficService.update(traffic);
         }
}