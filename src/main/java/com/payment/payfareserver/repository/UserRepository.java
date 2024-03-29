package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(int userId);

    User findUsersByPhone(String phone);

    User findUserByPhoneAndPassword(String phone, String password);

    List<User> findUsersByTypeId(int typeId);


}