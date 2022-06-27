package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.BlockDTO;
import com.payment.payfareserver.entity.*;
import com.payment.payfareserver.service.*;
import com.payment.payfareserver.utilities.SHA256Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class QueueController {
    @Autowired
    QueueService queueService;
    @Autowired
    CarService carService;
    @Autowired
    TripService tripService;
    @Autowired
    private DriverService driverService;

    @Autowired
    private AdminService adminService;
    @Autowired
    private BlockchainService blockchainService;
    @GetMapping("/queue")
    public List<Queue> getQueue() {
        return queueService.getQueue();
    }

    @PostMapping("/add-to-queue")
    public Queue save(@RequestParam("driver_code") String driverCode) {
        Queue queue = new Queue();
        Integer numOfLastPerson = 0;
        if (queueService.getCount() != 0) {
            Queue oldQueue = queueService.getLastDriverInQueue();
            numOfLastPerson = oldQueue.getQueueNum();
        }
        queue.setDriverCode(driverCode);
        queue.setQueueNum(numOfLastPerson + 1);
        return queueService.addToQueue(queue);
    }

    @DeleteMapping("/delete-top")
    public String deleteTop(@RequestParam("adminId") int adminId) {
        Queue topInQueue = queueService.getTopDriverInQueue();
        Driver driver = driverService.getDriverByDriverCode(topInQueue.getDriverCode());
        Car car = carService.getCarByCarCode(driver.getCar().getCarCode());
        Trip trip = new Trip();
        trip.setTraffic(car.getTraffic());
        trip.setAdmin(adminService.getAdminById(adminId));
        trip.setDriver(car.getDriver());
        trip.setCar(car);
        trip.setPrice((car.getTraffic().getPrice()*car.getCarCapacity()));

        Blockchain newBlock = new Blockchain();
        Blockchain oldBlock =blockchainService.getLastBlock();
        BlockDTO blockDto = new BlockDTO();
        blockDto.setData(SHA256Helper.randomString(20));
        if(blockchainService.getCount()==0) {
            blockDto.setPreviousHash("0000000000000000000000000000000000000000000000000000000000000000");
            blockDto.setNonce(0);
        }else{
            blockDto.setPreviousHash(oldBlock.getHash());
            blockDto.setNonce(oldBlock.getNonce());
            blockDto.incrementNonce();
        }
        blockDto.generateHash();
        newBlock.setHash(blockDto.getHash());
        newBlock.setPreviousHash(blockDto.getPreviousHash());
        newBlock.setNonce(blockDto.getNonce());
        newBlock.setTrip(tripService.save(trip));
        blockchainService.save(newBlock);

        queueService.deleteTopFromQueue();
        if (queueService.getCount() > 1) {
            queueService.updateQueue();
        }
        return "Successful Delete And Create New Trip";
    }
}
