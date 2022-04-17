package com.payment.payfareserver.repository;
import com.payment.payfareserver.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientById(int clientId);
    Client findClientByUserId(int userId);
}