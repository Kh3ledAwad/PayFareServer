package com.payment.payfareserver.controller;

import com.payment.payfareserver.Service.AdminService;
import com.payment.payfareserver.dto.AdminDTO;
import com.payment.payfareserver.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin/get-all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @RequestMapping(value = "/admin/get-by-id", method = RequestMethod.GET)
    public Admin getAdminById(@RequestParam("id") int adminId) {
        return adminService.getAdminById(adminId);
    }

    @PostMapping("/admin/save-admin")
    public Admin save(@RequestBody AdminDTO adminDTO) {
        Admin admin = new Admin();
        return admin;
    }
    
}