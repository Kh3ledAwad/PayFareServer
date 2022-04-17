package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(int userId);//add

    User findUserByIdAndTypeId(int userId, int typeId); //

     List<User> findUsersByTypeId(int typeId);

}