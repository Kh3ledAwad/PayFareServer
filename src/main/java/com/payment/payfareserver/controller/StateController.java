package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.StateService;
import com.payment.payfareserver.dto.StateDTO;
import com.payment.payfareserver.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/state/get-all")
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @RequestMapping(value = "/state/get-by-id", method = RequestMethod.GET)
    public State getStateById(@RequestParam("id") int stateId) {
        return stateService.getStateById(stateId);
    }

    @PostMapping("/state/save-state")
    public State save(@RequestBody StateDTO stateDTO) {
        State state = new State();
        return state;
    }


}