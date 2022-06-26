package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    private Car car;

    @Column(name = "driver_code", nullable = false, length = 225,unique = true)
    private String driverCode;

    @Column(name = "status", nullable = false)
    private Integer status;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false,unique = true)
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    private User user;

    @Column(name = "lice_num", nullable = false, length = 225,unique = true)
    private String liceNum;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private Double amount;

    @OneToMany(mappedBy = "driver")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<Trip> trips = new LinkedHashSet<>();

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double wallet) {
        this.amount = wallet;
    }

    public String getLiceNum() {
        return liceNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setLiceNum(String liceNum) {
        this.liceNum = liceNum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}