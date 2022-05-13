package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;

public class AdminDTO  {
    private  Integer id;
    private  StationDTO station;
    private  UserDTO user;
    private  Set<TripDTO> trips;

    public AdminDTO(Integer id, StationDTO station, UserDTO user, Set<TripDTO> trips) {
        this.id = id;
        this.station = station;
        this.user = user;
        this.trips = trips;
    }

    public AdminDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStation(StationDTO station) {
        this.station = station;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setTrips(Set<TripDTO> trips) {
        this.trips = trips;
    }

    public Integer getId() {
        return id;
    }

    public StationDTO getStation() {
        return station;
    }

    public UserDTO getUser() {
        return user;
    }

    public Set<TripDTO> getTrips() {
        return trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminDTO entity = (AdminDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.station, entity.station) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.trips, entity.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, station, user, trips);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "station = " + station + ", " +
                "user = " + user + ", " +
                "trips = " + trips + ")";
    }
}
