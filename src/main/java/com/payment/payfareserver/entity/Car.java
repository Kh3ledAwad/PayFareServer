package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private Integer id;

    @Column(name = "car_code", nullable = false, length = 225,unique = true)
    private String carCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "main_station_id", nullable = false)
    @JsonManagedReference
    private Station mainStation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "traffic_id", nullable = false)
    @JsonManagedReference
    private Traffic traffic;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonManagedReference
    private Owner owner;

    @Column(name = "car_plate_num", nullable = false, length = 225,unique = true)
    private String carPlateNum;

    @Column(name = "car_capacity", nullable = false)
    private Integer carCapacity;

    @Column(name = "qr_code", nullable = false, length = 225,unique = true)
    private String qrCode;

    @OneToMany(mappedBy = "car")
    @JsonBackReference
    private Set<Trip> trips = new LinkedHashSet<>();

    @OneToMany(mappedBy = "car")
    @JsonBackReference
    private Set<Driver> drivers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public Station getMainStation() {
        return mainStation;
    }

    public void setMainStation(Station mainStation) {
        this.mainStation = mainStation;
    }

    public Traffic getTraffic() {
        return traffic;
    }

    public void setTraffic(Traffic traffic) {
        this.traffic = traffic;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlatenum) {
        this.carPlateNum = carPlatenum;
    }

    public Integer getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(Integer carCapacity) {
        this.carCapacity = carCapacity;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

}