package com.payment.payfareserver.service;

import com.payment.payfareserver.entity.User;
import com.payment.payfareserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }
    public void delete(int userId){
        repository.deleteById(userId);
    }
    public List<User>getAllUsers() {
        List<User> users = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(users::add);
        return users;
    }

    public List<User> getUsersByTypeId(int typeId) {
        return repository.findUsersByTypeId(typeId);
    }

    public User getUserById(int userId) {
        return repository.findUserById(userId);
    }

    public int getCount() {
        return (int) repository.count();
    }


}