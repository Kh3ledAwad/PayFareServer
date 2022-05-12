package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.util.Objects;

public class ChairDto  {
    private  Integer id;
    private  CarDTO car;
    private  Integer chairNumber;
    private  Integer status;

    public ChairDto(Integer id, CarDTO car, Integer chairNumber, Integer status) {
        this.id = id;
        this.car = car;
        this.chairNumber = chairNumber;
        this.status = status;
    }

    public ChairDto() {
    }

    public Integer getId() {
        return id;
    }

    public CarDTO getCar() {
        return car;
    }

    public Integer getChairNumber() {
        return chairNumber;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChairDto entity = (ChairDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.car, entity.car) &&
                Objects.equals(this.chairNumber, entity.chairNumber) &&
                Objects.equals(this.status, entity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car, chairNumber, status);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "car = " + car + ", " +
                "chairNumber = " + chairNumber + ", " +
                "status = " + status + ")";
    }
}
