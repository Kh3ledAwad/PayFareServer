package com.payment.payfareserver.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class TripDTO {
    private  Integer id;
    private  LocalDateTime date;
    private  BigDecimal price;
    private  AdminDTO admin;
    private  CarDTO car;
    private  DriverDTO driver;
    private  TrafficDTO traffic;
    private  Set<RidesHistoryDTO> ridesHistories;
    private  Set<BlockchainDto> block;

    public TripDTO(Integer id, LocalDateTime date, BigDecimal price, AdminDTO admin, CarDTO car, DriverDTO driver, TrafficDTO traffic, Set<RidesHistoryDTO> ridesHistories, Set<BlockchainDto> block) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.admin = admin;
        this.car = car;
        this.driver = driver;
        this.traffic = traffic;
        this.ridesHistories = ridesHistories;
        this.block = block;
    }

    public TripDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public void setTraffic(TrafficDTO traffic) {
        this.traffic = traffic;
    }

    public void setRidesHistories(Set<RidesHistoryDTO> ridesHistories) {
        this.ridesHistories = ridesHistories;
    }

    public void setBlock(Set<BlockchainDto> block) {
        this.block = block;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public CarDTO getCar() {
        return car;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public TrafficDTO getTraffic() {
        return traffic;
    }

    public Set<RidesHistoryDTO> getRidesHistories() {
        return ridesHistories;
    }

    public Set<BlockchainDto> getBlock() {
        return block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDTO entity = (TripDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.date, entity.date) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.admin, entity.admin) &&
                Objects.equals(this.car, entity.car) &&
                Objects.equals(this.driver, entity.driver) &&
                Objects.equals(this.traffic, entity.traffic) &&
                Objects.equals(this.ridesHistories, entity.ridesHistories) &&
                Objects.equals(this.block, entity.block);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, price, admin, car, driver, traffic, ridesHistories, block);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id ;
    }
}
