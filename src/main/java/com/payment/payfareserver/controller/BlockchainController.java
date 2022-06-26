package com.payment.payfareserver.controller;

import com.payment.payfareserver.entity.Blockchain;
import com.payment.payfareserver.service.BlockchainService;
import com.payment.payfareserver.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BlockchainController {
    @Autowired
    BlockchainService blockchainService;

    @GetMapping("/blocks")
    public List<Blockchain> getAllBlockchains() {
        return blockchainService.getAllBlocks();
    }

    @GetMapping("/block")
    public Blockchain getLastBlock() {
        return blockchainService.getLastBlock();
    }

    @GetMapping("/block/number")
    public int getCount() {
        return blockchainService.getCount();
    }

}

