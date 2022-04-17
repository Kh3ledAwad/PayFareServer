package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.TypeService;
import com.payment.payfareserver.dto.TypeDTO;
import com.payment.payfareserver.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;
   // @Autowired
   // private CompanyDAO companyDAO;

    @GetMapping("/type/get-all")
    public List<Type> getAllTypes() {

        return typeService.getAllTypes();
    }

    @RequestMapping(value = "/type/get-by-id", method = RequestMethod.GET)
    public Type getTypeById(@RequestParam("id") int typeId) {
        return typeService.getTypeById(typeId);
    }

    @RequestMapping(value = "/type/get-by-name", method = RequestMethod.GET)
    public Type getTypeByName(@RequestParam("name") String typeName) {
        return typeService.getTypeByName(typeName);
    }
}