package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.Admin;
import com.payment.payfareserver.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;
    public Admin save(Admin admin) {
        return repository.save(admin);
    }
    public Admin update(Admin admin) {
        return repository.save(admin);
    }
    public void delete(int adminId) {
        repository.deleteById(adminId);
    }
    public List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(admins::add);
        return admins;
    }

    public Admin getAdminById(int adminId) {
        return repository.findAdminById(adminId);
    }

    public Admin getAdminByUserId(int userId) {
        return repository.findAdminByUserId(userId);
    }
    public int getCount() {
        return (int) repository.count();
    }

}