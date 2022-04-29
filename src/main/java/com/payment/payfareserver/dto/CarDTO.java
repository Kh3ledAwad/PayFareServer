package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;

public class CarDTO {
    private  Integer id;
    private  String carCode;
    private  StationDTO mainStation;
    private  TrafficDTO traffic;
    private  OwnerDTO owner;
    private  String carPlateNum;
    private  Integer carCapacity;
    private  String qrCode;
    private  Set<TripDTO> trips;
    private  Set<DriverDTO> drivers;

    public CarDTO(Integer id, String carCode, StationDTO mainStation, TrafficDTO traffic, OwnerDTO owner, String carPlateNum, Integer carCapacity, String qrCode, Set<TripDTO> trips, Set<DriverDTO> drivers) {
        this.id = id;
        this.carCode = carCode;
        this.mainStation = mainStation;
        this.traffic = traffic;
        this.owner = owner;
        this.carPlateNum = carPlateNum;
        this.carCapacity = carCapacity;
        this.qrCode = qrCode;
        this.trips = trips;
        this.drivers = drivers;
    }

    public CarDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public void setMainStation(StationDTO mainStation) {
        this.mainStation = mainStation;
    }

    public void setTraffic(TrafficDTO traffic) {
        this.traffic = traffic;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void setTrips(Set<TripDTO> trips) {
        this.trips = trips;
    }

    public void setDrivers(Set<DriverDTO> drivers) {
        this.drivers = drivers;
    }

    public Integer getId() {
        return id;
    }

    public String getCarCode() {
        return carCode;
    }

    public StationDTO getMainStation() {
        return mainStation;
    }

    public TrafficDTO getTraffic() {
        return traffic;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public Integer getCarCapacity() {
        return carCapacity;
    }

    public String getQrCode() {
        return qrCode;
    }

    public Set<TripDTO> getTrips() {
        return trips;
    }

    public Set<DriverDTO> getDrivers() {
        return drivers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDTO entity = (CarDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.carCode, entity.carCode) &&
                Objects.equals(this.mainStation, entity.mainStation) &&
                Objects.equals(this.traffic, entity.traffic) &&
                Objects.equals(this.owner, entity.owner) &&
                Objects.equals(this.carPlateNum, entity.carPlateNum) &&
                Objects.equals(this.carCapacity, entity.carCapacity) &&
                Objects.equals(this.qrCode, entity.qrCode) &&
                Objects.equals(this.trips, entity.trips) &&
                Objects.equals(this.drivers, entity.drivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carCode, mainStation, traffic, owner, carPlateNum, carCapacity, qrCode, trips, drivers);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "carCode = " + carCode + ", " +
                "mainStation = " + mainStation + ", " +
                "traffic = " + traffic + ", " +
                "owner = " + owner + ", " +
                "carPlatenum = " + carPlateNum + ", " +
                "carCapacity = " + carCapacity + ", " +
                "qrCode = " + qrCode + ", " +
                "trips = " + trips + ", " +
                "drivers = " + drivers + ")";
    }
}
