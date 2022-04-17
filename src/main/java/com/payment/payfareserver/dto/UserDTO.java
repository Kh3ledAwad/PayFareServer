package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class UserDTO   {
    private  Integer id;
    private  String name;
    private  String userName;
    private  String password;
    private  String phone;
    private  TypeDTO type;
    private  Set<DriverDTO> drivers;
    private  Set<ClientDTO> clients;
    private  Set<AdminDTO> admins;

    public UserDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    public void setDrivers(Set<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public void setClients(Set<ClientDTO> clients) {
        this.clients = clients;
    }

    public void setAdmins(Set<AdminDTO> admins) {
        this.admins = admins;
    }

    public UserDTO(Integer id, String name, String userName, String password, String phone, TypeDTO type, Set<DriverDTO> drivers, Set<ClientDTO> clients, Set<AdminDTO> admins) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.drivers = drivers;
        this.clients = clients;
        this.admins = admins;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public TypeDTO getType() {
        return type;
    }

    public Set<DriverDTO> getDrivers() {
        return drivers;
    }

    public Set<ClientDTO> getClients() {
        return clients;
    }

    public Set<AdminDTO> getAdmins() {
        return admins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO entity = (UserDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.userName, entity.userName) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.drivers, entity.drivers) &&
                Objects.equals(this.clients, entity.clients) &&
                Objects.equals(this.admins, entity.admins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userName, password, phone, type, drivers, clients, admins);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "userName = " + userName + ", " +
                "password = " + password + ", " +
                "phone = " + phone + ", " +
                "type = " + type + ", " +
                "drivers = " + drivers + ", " +
                "clients = " + clients + ", " +
                "admins = " + admins + ")";
    }
}
