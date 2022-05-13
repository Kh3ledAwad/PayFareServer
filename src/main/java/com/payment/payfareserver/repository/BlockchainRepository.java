package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Blockchain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockchainRepository extends JpaRepository<Blockchain, Integer> {
    Blockchain findTopByOrderByIdDesc();

}
