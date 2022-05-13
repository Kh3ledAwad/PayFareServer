package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.StateDTO;
import com.payment.payfareserver.entity.State;
import com.payment.payfareserver.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/state")
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @PostMapping("/state")
    public State save(@RequestBody StateDTO stateDTO) {
        State state = new State();
        state.setStateNameAr(stateDTO.getStateNameAr());
        state.setStateNameEn(stateDTO.getStateNameEn());
        return stateService.save(state);
    }

    @RequestMapping(value = "/state/get-by-id", method = RequestMethod.GET)
    public State getStateById(@RequestParam("id") int stateId) {
        return stateService.getStateById(stateId);
    }

    @RequestMapping(value = "/state/get-by-name-arabic", method = RequestMethod.GET)
    public State getStateByStateNameAr(@RequestParam("stateNameAr") String stateNameAr) {
        return stateService.getStateByStateNameAr(stateNameAr);
    }

    @RequestMapping(value = "/state/get-by-name-english", method = RequestMethod.GET)
    public State getStateByStateNameEn(@RequestParam("stateNameEn") String stateNameEn) {
        return stateService.getStateByStateNameEn(stateNameEn);
    }

}