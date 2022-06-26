package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.RidesHistoryDTO;
import com.payment.payfareserver.entity.RidesHistory;
import com.payment.payfareserver.service.RidesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RidesHistoryController {

    @Autowired
    private RidesHistoryService ridesHistoryService;

    @GetMapping("/ridesHistory/get-all")
    public List<RidesHistory> getAllRidesHistory() {
        return ridesHistoryService.getAllRidesHistory();
    }

    @RequestMapping(value = "/ridesHistory/get-by-id", method = RequestMethod.GET)
    public RidesHistory getRidesHistoryById(@RequestParam("id") int ridesHistoryId) {
        return ridesHistoryService.getRidesHistoryById(ridesHistoryId);
    }

    @PostMapping("/ridesHistory/save-ridesHistory")
    public RidesHistory save(@RequestBody RidesHistoryDTO ridesHistoryDTO) {
        RidesHistory ridesHistory = new RidesHistory();

        return ridesHistoryService.save(ridesHistory);
    }


}