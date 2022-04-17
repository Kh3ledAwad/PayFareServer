package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * Created by khaledawad on 4/13/2022.
 */
public class DriverDTO  {
    private  Integer id;
    private  CarDTO car;
    private  String driverCode;
    private  UserDTO user;
    private  String carCode;
    private  String liceNum;
    private  BigDecimal wallet;
    private  Set<TripDTO> trips;

    public DriverDTO(Integer id, CarDTO car, String driverCode, UserDTO user, String carCode, String liceNum, BigDecimal wallet, Set<TripDTO> trips) {
        this.id = id;
        this.car = car;
        this.driverCode = driverCode;
        this.user = user;
        this.carCode = carCode;
        this.liceNum = liceNum;
        this.wallet = wallet;
        this.trips = trips;
    }

    public DriverDTO() {
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

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public void setLiceNum(String liceNum) {
        this.liceNum = liceNum;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
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

    public String getCarCode() {
        return carCode;
    }

    public String getLiceNum() {
        return liceNum;
    }

    public BigDecimal getWallet() {
        return wallet;
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
                Objects.equals(this.carCode, entity.carCode) &&
                Objects.equals(this.liceNum, entity.liceNum) &&
                Objects.equals(this.wallet, entity.wallet) &&
                Objects.equals(this.trips, entity.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, driverCode, user, carCode, liceNum, wallet, trips);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "car = " + car + ", " +
                "driverCode = " + driverCode + ", " +
                "user = " + user + ", " +
                "carCode = " + carCode + ", " +
                "liceNum = " + liceNum + ", " +
                "wallet = " + wallet + ", " +
                "trips = " + trips + ")";
    }
}
