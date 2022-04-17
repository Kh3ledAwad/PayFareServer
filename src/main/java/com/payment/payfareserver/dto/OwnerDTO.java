package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class OwnerDTO  {
    private  Integer id;
    private  String password;
    private  String phone;
    private  String username;
    private  Set<CarDTO> cars;

    public OwnerDTO(Integer id, String password, String phone, String username, Set<CarDTO> cars) {
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.cars = cars;
    }

    public OwnerDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCars(Set<CarDTO> cars) {
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public Set<CarDTO> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDTO entity = (OwnerDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.cars, entity.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, phone, username, cars);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "password = " + password + ", " +
                "phone = " + phone + ", " +
                "username = " + username + ", " +
                "cars = " + cars + ")";
    }
}
