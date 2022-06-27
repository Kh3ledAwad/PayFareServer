package com.payment.payfareserver.utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.payment.payfareserver.entity.Trip;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarTrips {
    @JsonProperty("carNumber")
    private int carNumber;
    @JsonProperty("trips")
    private Set<Trip> trips;
    @JsonProperty("totalPrice")
    private Double total;
    public CarTrips() {
    }

    public CarTrips(int carNumber, Set<Trip> trips, Double total) {
        this.carNumber = carNumber;
        this.trips = trips;
        this.total = total;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}