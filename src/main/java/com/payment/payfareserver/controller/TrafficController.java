package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.TrafficService;
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

    @GetMapping("/traffic/get-all")
    public List<Traffic> getAllTraffics() {
        return trafficService.getAllTraffics();
    }

    @RequestMapping(value = "/traffic/get-by-id", method = RequestMethod.GET)
    public Traffic getTrafficById(@RequestParam("id") int trafficId) {
        return trafficService.getTrafficById(trafficId);
    }

    @PostMapping("/traffic/save-traffic")
    public Traffic save(@RequestBody TrafficDTO trafficDTO) {
        Traffic traffic = new Traffic();
        return traffic;
    }


}