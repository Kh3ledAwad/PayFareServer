package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientById(int clientId);

    Client findClientByUserId(int userId);

    Client findClientByUserPhone(String phone);

    @Transactional
    @Modifying
    @Query("update Client c set c.amount = c.amount-?1 where c.id=?2")
    void updateWallet(double val, int id);
}