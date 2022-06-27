package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findAdminById(int adminId);
    Admin findAdminByUserId(int userId);

}