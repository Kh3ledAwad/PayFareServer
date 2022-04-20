package com.payment.payfareserver.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    State findStateById(int stateId);

    State findStateByIdUserId(int userId);
}