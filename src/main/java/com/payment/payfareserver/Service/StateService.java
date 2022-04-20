package com.payment.payfareserver.Service;

import com.payment.payfareserver.entity.State;
import com.payment.payfareserver.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public State save(State state) {
        return repository.save(state);
    }

    public State update(State state) {
        return repository.save(state);
    }

    public void delete(int stateId) {
        repository.deleteById(stateId);
    }

    public List<State> getAllStates() {
        List<State> states = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(states::add);
        return states;
    }

    public State getStateById(int stateId) {
        return repository.findStateById(stateId);
    }


    public State getStateByStateNameAr(String stateNameAr) {
        return repository.findStateByStateNameAr(stateNameAr);
    }

    public State getStateByStateNameEn(String stateNameEn) {
        return repository.findStateByStateNameEn(stateNameEn);
    }

    public int getCount() {
        return (int) repository.count();
    }
}