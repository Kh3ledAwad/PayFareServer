package com.payment.payfareserver.repository;

import com.payment.payfareserver.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    State findStateById(int stateId);

    State findStateByStateNameAr(String stateNameAr);

    State findStateByStateNameEn(String stateNameEn);


}