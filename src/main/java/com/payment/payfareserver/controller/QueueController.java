package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.AdminDTO;
import com.payment.payfareserver.dto.QueueDto;
import com.payment.payfareserver.entity.Admin;
import com.payment.payfareserver.entity.Queue;
import com.payment.payfareserver.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class QueueController {
    @Autowired
    QueueService queueService;

    @GetMapping("/queue")
    public List<Queue> getQueue(){
        return queueService.getQueue();
    }
    @PostMapping("/add-to-queue")
    public Queue save(@RequestParam("driver_code") String driverCode) {
        Queue queue = new Queue();
        Integer numOfLastPerson = 0;
        if (queueService.getCount() != 0) {
            Queue oldQueue = queueService.getLastPersonInQueue();
            numOfLastPerson = oldQueue.getQueueNum();
        }
        queue.setDriverCode(driverCode);
        queue.setQueueNum(numOfLastPerson + 1);
        return queueService.addToQueue(queue);
    }

    @DeleteMapping("/delete-top")
    public Boolean deleteTop() {
        queueService.deleteTopFromQueue();
        if (queueService.getCount() > 1) {
            queueService.updateQueue();
        }
        return true;
    }
}
