package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.OwnerDTO;
import com.payment.payfareserver.entity.Car;
import com.payment.payfareserver.entity.Owner;
import com.payment.payfareserver.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owner")
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @RequestMapping(value = "/owner/get-by-id", method = RequestMethod.GET)
    public Owner getOwnerById(@RequestParam("id") int ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    @PostMapping("/owner/login")
    public Owner login(@RequestBody OwnerDTO ownerDTO) {
        return ownerService.login(ownerDTO.getPhone(), ownerDTO.getPassword());
    }

    @PostMapping("/owner")
    public Owner save(@RequestBody OwnerDTO ownerDTO) {
        Owner owner = new Owner();

        if (ownerDTO.getId() != null)
            owner.setId(ownerDTO.getId());

        owner.setFullName(ownerDTO.getFullName());
        owner.setPassword(ownerDTO.getPassword());
        owner.setUsername(ownerDTO.getUsername());
        owner.setPhone(ownerDTO.getPhone());
        return ownerService.save(owner);
    }

    @RequestMapping(value = "/owner/cars", method = RequestMethod.GET)
    public List<Car> getAllCarsByOwnerId(@RequestParam("owner_id") int ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        return owner.getCars();
    }
    @RequestMapping(value = "/owner/number-of-car", method = RequestMethod.GET)
    public int getNumberOfCarsByOwnerId(@RequestParam("owner_id") int ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        return owner.getCars().size();
    }

    @PutMapping("/owner")
    public Owner update(@RequestBody OwnerDTO ownerDTO) {
        return save(ownerDTO);
    }

    @DeleteMapping("/owner")
    public Boolean delete(@RequestParam("id") int ownerId) {
        Owner owner = ownerService.getOwnerById(ownerId);
        ownerService.delete(owner.getId());
        return true;
    }
}