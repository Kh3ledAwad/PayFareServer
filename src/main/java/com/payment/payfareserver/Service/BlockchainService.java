package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Blockchain;
import com.payment.payfareserver.repository.BlockchainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockchainService {
    @Autowired
    BlockchainRepository repository;
    public Blockchain save(Blockchain blockchain){
        return repository.save(blockchain);
    }
    public Blockchain getLastBlock(){
        return repository.findTopByOrderByIdDesc();
    }
    public List<Blockchain> getAllBlocks() {
        List<Blockchain> blockchains = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(blockchains::add);
        return blockchains;
    }
    public int getCount() {
        return (int) repository.count();
    }
}
