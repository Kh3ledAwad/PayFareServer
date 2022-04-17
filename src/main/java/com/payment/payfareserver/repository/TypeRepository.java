package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    Type findTypeById(int typeId);
    Type findTypeByName(String typeName);
    List<Type> findTypesByName(String typeName);
}