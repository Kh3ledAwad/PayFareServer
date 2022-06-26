package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Queue;
import com.payment.payfareserver.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueService {
    @Autowired
    private QueueRepository repository;

    public List<Queue> getQueue() {

        return repository.findAllByOrderByQueueNumAsc();
    }

    public void updateQueue() {
        repository.updateQueue();
    }

    public Queue addToQueue(Queue queue) {
        return repository.save(queue);
    }

    public Queue getLastDriverInQueue() {
        return repository.findTopByOrderByIdDesc();
    }
    public Queue getTopDriverInQueue(){
        return repository.findQueueByQueueNum(1);
    }
    public long getCount() {
        return repository.count();
    }

    public boolean deleteTopFromQueue() {
        repository.deleteTop();
        return true;
    }
}
