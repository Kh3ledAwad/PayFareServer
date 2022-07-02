package com.payment.payfareserver.controller;

import com.payment.payfareserver.dto.UserDTO;
import com.payment.payfareserver.entity.Client;
import com.payment.payfareserver.entity.User;
import com.payment.payfareserver.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private ClientService clientService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private AdminService adminService;

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

    @RequestMapping(value = "/user/get-by-phone", method = RequestMethod.GET)
    public User getUserByPhone(@RequestParam("phone") String phone) {
        return userService.getUserByPhone(phone);
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

    @PostMapping("/user/login")
    public Optional<Object> login(@RequestBody UserDTO userDTO) {
        User user = userService.login(userDTO.getPhone(), userDTO.getPassword());
        if(user==null)
            return Optional.of("User Not Found");
        if (user.getType().getId().equals(3)) {
            return Optional.ofNullable(clientService.getClientByUserId(user.getId()));
        } else if (user.getType().getId().equals(2)) {
            return Optional.ofNullable(driverService.getDriverByUserId(user.getId()));
        } else
            return Optional.of(adminService.getAdminByUserId(user.getId()));
    }

}