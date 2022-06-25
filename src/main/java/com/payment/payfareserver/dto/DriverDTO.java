package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;
public class DriverDTO  {
    private  Integer id;
    private  CarDTO car;
    private  String driverCode;
    private  UserDTO user;
    private  String liceNum;

    private Integer status;
    private  Double amount;
    private  Set<TripDTO> trips;

    public DriverDTO(Integer id, CarDTO car, String driverCode, UserDTO user, String liceNum, Double amount, Set<TripDTO> trips) {
        this.id = id;
        this.car = car;
        this.driverCode = driverCode;
        this.user = user;
        this.liceNum = liceNum;
        this.amount = amount;
        this.trips = trips;
    }

    public DriverDTO() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setLiceNum(String liceNum) {
        this.liceNum = liceNum;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setTrips(Set<TripDTO> trips) {
        this.trips = trips;
    }

    public Integer getId() {
        return id;
    }

    public CarDTO getCar() {
        return car;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public UserDTO getUser() {
        return user;
    }

    public String getLiceNum() {
        return liceNum;
    }

    public Double getAmount() {
        return amount;
    }

    public Set<TripDTO> getTrips() {
        return trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverDTO entity = (DriverDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.car, entity.car) &&
                Objects.equals(this.driverCode, entity.driverCode) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.liceNum, entity.liceNum) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.trips, entity.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, driverCode, user, liceNum, amount, trips);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "car = " + car + ", " +
                "driverCode = " + driverCode + ", " +
                "user = " + user + ", " +
                "liceNum = " + liceNum + ", " +
                "wallet = " + amount + ", " +
                "trips = " + trips + ")";
    }
}
