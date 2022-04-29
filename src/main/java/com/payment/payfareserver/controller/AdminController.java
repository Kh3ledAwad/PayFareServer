package com.payment.payfareserver.controller;

import com.payment.payfareserver.service.AdminService;
import com.payment.payfareserver.service.StationService;
import com.payment.payfareserver.service.TypeService;
import com.payment.payfareserver.service.UserService;
import com.payment.payfareserver.dto.AdminDTO;
import com.payment.payfareserver.entity.Admin;
import com.payment.payfareserver.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private StationService stationService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/admin")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping("/admin")
    public Admin save(@RequestBody AdminDTO adminDTO) {
        Admin admin = new Admin();
        User user = new User();
        user.setName(adminDTO.getUser().getName());
        user.setUserName(adminDTO.getUser().getUserName());
        user.setPassword(adminDTO.getUser().getPassword());
        user.setPhone(adminDTO.getUser().getPhone());
        user.setType(typeService.getTypeById(1));
        admin.setUser(userService.save(user));
        admin.setStation(stationService.getStationById(adminDTO.getStation().getId()));
        return adminService.save(admin);
    }

    @PutMapping("/admin")
    public Admin update(@RequestBody AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setId(admin.getId());

        return null;
    }

    @RequestMapping(value = "/admin/get-by-id", method = RequestMethod.GET)
    public Admin getAdminById(@RequestParam("id") int adminId) {
        return adminService.getAdminById(adminId);
    }

}