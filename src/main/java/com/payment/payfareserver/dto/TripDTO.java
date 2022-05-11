package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

public class TripDTO  {
    private  Integer id;
    private  Integer traId;
    private  BigDecimal traPrice;
    private  String traFrom;
    private  String traTo;
    private  AdminDTO admin;
    private  DriverDTO driver;
    private  CarDTO car;
    private LocalDateTime date;
    private  BigDecimal price;
    private  Set<RidesHistoryDTO> rideshistories;

    public TripDTO(Integer id, Integer traId, BigDecimal traPrice, String traFrom, String traTo, AdminDTO admin, DriverDTO driver, CarDTO car, LocalDateTime date, BigDecimal price, Set<RidesHistoryDTO> rideshistories) {
        this.id = id;
        this.traId = traId;
        this.traPrice = traPrice;
        this.traFrom = traFrom;
        this.traTo = traTo;
        this.admin = admin;
        this.driver = driver;
        this.car = car;
        this.date = date;
        this.price = price;
        this.rideshistories = rideshistories;
    }

    public TripDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    public void setTraPrice(BigDecimal traPrice) {
        this.traPrice = traPrice;
    }

    public void setTraFrom(String traFrom) {
        this.traFrom = traFrom;
    }

    public void setTraTo(String traTo) {
        this.traTo = traTo;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRideshistories(Set<RidesHistoryDTO> rideshistories) {
        this.rideshistories = rideshistories;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTraId() {
        return traId;
    }

    public BigDecimal getTraPrice() {
        return traPrice;
    }

    public String getTraFrom() {
        return traFrom;
    }

    public String getTraTo() {
        return traTo;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public CarDTO getCar() {
        return car;
    }

    public LocalDateTime getDate() {
        return date;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public Set<RidesHistoryDTO> getRideshistories() {
        return rideshistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDTO entity = (TripDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.traId, entity.traId) &&
                Objects.equals(this.traPrice, entity.traPrice) &&
                Objects.equals(this.traFrom, entity.traFrom) &&
                Objects.equals(this.traTo, entity.traTo) &&
                Objects.equals(this.admin, entity.admin) &&
                Objects.equals(this.driver, entity.driver) &&
                Objects.equals(this.car, entity.car) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.rideshistories, entity.rideshistories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, traId, traPrice, traFrom, traTo, admin, driver, car, date, price, rideshistories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "traId = " + traId + ", " +
                "traPrice = " + traPrice + ", " +
                "traFrom = " + traFrom + ", " +
                "traTo = " + traTo + ", " +
                "admin = " + admin + ", " +
                "driver = " + driver + ", " +
                "car = " + car + ", " +
                "date = " + date + ", " +
                "price = " + price + ", " +
                "rideshistories = " + rideshistories + ")";
    }
}
