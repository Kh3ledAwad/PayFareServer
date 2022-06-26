package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Integer> {
    @Transactional
    @Modifying
    @Query("update Queue q set q.queueNum = q.queueNum-1")
    void updateQueue();
    @Transactional
    @Modifying
    @Query("delete from Queue q where q.queueNum = 1")
    void deleteTop ();
    Queue findTopByOrderByIdDesc();
    List<Queue> findAllByOrderByQueueNumAsc();

}
