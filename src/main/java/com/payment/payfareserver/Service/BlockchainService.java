package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Blockchain;
import com.payment.payfareserver.repository.BlockchainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockchainService {
    @Autowired
    BlockchainRepository repository;
    public Blockchain save(Blockchain blockchain){
        return repository.save(blockchain);
    }
}
