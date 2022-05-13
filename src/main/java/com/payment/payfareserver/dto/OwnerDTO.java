package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;

public class OwnerDTO  {
    private  Integer id;
    private String fullName;
    private  String password;
    private  String phone;
    private  String username;
    private  Set<CarDTO> cars;

    public OwnerDTO(Integer id, String fullName, String password, String phone, String username, Set<CarDTO> cars) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.cars = cars;
    }


    public OwnerDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        if (!(o instanceof OwnerDTO)) return false;
        OwnerDTO ownerDTO = (OwnerDTO) o;
        return Objects.equals(getId(), ownerDTO.getId()) && Objects.equals(getFullName(), ownerDTO.getFullName()) && Objects.equals(getPassword(), ownerDTO.getPassword()) && Objects.equals(getPhone(), ownerDTO.getPhone()) && Objects.equals(getUsername(), ownerDTO.getUsername()) && Objects.equals(getCars(), ownerDTO.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getPassword(), getPhone(), getUsername(), getCars());
    }

    @Override
    public String toString() {
        return "OwnerDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", cars=" + cars +
                '}';
    }
}
