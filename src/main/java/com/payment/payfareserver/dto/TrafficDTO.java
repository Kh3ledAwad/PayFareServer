package com.payment.payfareserver.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * Created by khaledawad on 4/13/2022.
 */
public class TrafficDTO  {
    private  Integer id;
    private  StationDTO station;
    private  BigDecimal price;
    private  String from;
    private  String to;
    private  Set<TripDTO> trips;
    private  Set<CarDTO> cars;

    public TrafficDTO(Integer id, StationDTO station, BigDecimal price, String from, String to, Set<TripDTO> trips, Set<CarDTO> cars) {
        this.id = id;
        this.station = station;
        this.price = price;
        this.from = from;
        this.to = to;
        this.trips = trips;
        this.cars = cars;
    }

    public TrafficDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStation(StationDTO station) {
        this.station = station;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setTrips(Set<TripDTO> trips) {
        this.trips = trips;
    }

    public void setCars(Set<CarDTO> cars) {
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public StationDTO getStation() {
        return station;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Set<TripDTO> getTrips() {
        return trips;
    }

    public Set<CarDTO> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficDTO entity = (TrafficDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.station, entity.station) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.from, entity.from) &&
                Objects.equals(this.to, entity.to) &&
                Objects.equals(this.trips, entity.trips) &&
                Objects.equals(this.cars, entity.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, station, price, from, to, trips, cars);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "station = " + station + ", " +
                "price = " + price + ", " +
                "from = " + from + ", " +
                "to = " + to + ", " +
                "trips = " + trips + ", " +
                "cars = " + cars + ")";
    }
}
