package com.payment.payfareserver.Service;

import com.payment.payfareserver.entity.Owner;
import com.payment.payfareserver.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public Owner save(Owner owner) {
        return repository.save(owner);
    }

    public List<Owner> getAllOwners() {
        List<Owner> owners = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(owners::add);
        return owners;
    }

    public Owner getOwnerById(int ownerId) {
        return repository.findOwnerById(ownerId);
    }

    public int getCount() {
        return (int) repository.count();
    }

}