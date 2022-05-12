package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.BlockchainDto;
import com.payment.payfareserver.dto.TripDTO;
import com.payment.payfareserver.entity.Blockchain;
import com.payment.payfareserver.service.BlockchainService;
import com.payment.payfareserver.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class BlockchainController {
    @Autowired
    private TripService tripService;
    @Autowired
    BlockchainService blockchainService;

    @PostMapping("/block")
    public Blockchain save(@RequestBody TripDTO tripDTO) {
        Blockchain blockchain = new Blockchain();
        return blockchainService.save(blockchain);
    }
}

