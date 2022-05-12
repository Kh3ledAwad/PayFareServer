package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.BlockchainDto;
import com.payment.payfareserver.dto.TripDTO;
import com.payment.payfareserver.entity.Blockchain;
import com.payment.payfareserver.entity.Trip;
import com.payment.payfareserver.service.BlockchainService;
import com.payment.payfareserver.service.TripService;
import com.payment.payfareserver.utilities.SHA256Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private BlockchainService blockchainService;
    @GetMapping("/trip")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @RequestMapping(value = "/trip/get-by-id", method = RequestMethod.GET)
    public Trip getTripById(@RequestParam("id") int tripId) {
        return tripService.getTripById(tripId);
    }

    @PostMapping("/trip")
    public Boolean save() {
        Blockchain blockchain = new Blockchain();
        BlockchainDto blockchainDto = new BlockchainDto();
        blockchainDto.setData(SHA256Helper.randomString(20));
        blockchainDto.setPreviousHash("0000000000000000000000000000000000000000000000000000000000000000");
        blockchainDto.generateHash();
        blockchainDto.incrementNonce();
        blockchain.setHash(blockchainDto.getHash());
        blockchain.setPreviousHash(blockchainDto.getPreviousHash());
        blockchain.setNonce(blockchainDto.getNonce());
        blockchainService.save(blockchain);
        return true;
    }


}