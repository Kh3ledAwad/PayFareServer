package com.payment.payfareserver.controller;

import com.payment.payfareserver.entity.Chairs;
import com.payment.payfareserver.service.ChairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ChairsController {

    @Autowired
    private ChairsService chairsService;

    @GetMapping("/chairs")
    public List<Chairs> getAllChairs() {
        return chairsService.getAllChairs();
    }

    @RequestMapping(value = "/chairs/get-by-id", method = RequestMethod.GET)
    public Chairs getChairsById(@RequestParam("id") int chairsId) {
        return chairsService.getChairsById(chairsId);
    }

}