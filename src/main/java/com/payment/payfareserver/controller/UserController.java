package com.payment.payfareserver.controller;

import com.payment.payfareserver.service.ClientService;
import com.payment.payfareserver.service.TypeService;
import com.payment.payfareserver.service.UserService;
import com.payment.payfareserver.dto.UserDTO;
import com.payment.payfareserver.entity.Client;
import com.payment.payfareserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/user/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/get-by-type-id", method = RequestMethod.GET)
    public List<User> getUsersByTypeId(@RequestParam("id") int typeId) {
        return userService.getUsersByTypeId(typeId);
    }

    @RequestMapping(value = "/user/get-by-id", method = RequestMethod.GET)
    public User getUserById(@RequestParam("id") int userId) {

        return userService.getUserById(userId);
    }

    @RequestMapping(value = "/user/get-all-client", method = RequestMethod.GET)
    public Client getAllClientByUserId(@RequestParam("id") int userId) {
        return clientService.getClientByUserId(userId);
    }

    @PostMapping("/user/save-user")
    public User save(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setType(typeService.getTypeById(userDTO.getType().getId()));
        return userService.save(user);
    }

}