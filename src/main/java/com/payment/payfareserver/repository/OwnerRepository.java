package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

    Owner findOwnerById(int ownerId);
    Owner findOwnerByPhoneAndAndPassword(String phone,String password);

}