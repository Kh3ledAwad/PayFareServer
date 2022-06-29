package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 225)
    private String name;

    @Column(name = "user_name", nullable = false, length = 200,unique = true)
    private String userName;

    @Column(name = "password", nullable = false, length = 200)
    @JsonIgnore
    private String password;

    @Column(name = "phone", nullable = false, length = 20,unique = true)
    @Pattern(regexp = "^01[0125][0-9]{8}$")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonManagedReference
    private Type type;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Driver> drivers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Client> clients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Admin> admins = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}