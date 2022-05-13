package com.payment.payfareserver.dto;

import java.util.Objects;

/**
 * Created by khaledawad on 4/13/2022.
 */
public class RidesHistoryDTO  {
    private  Integer id;
    private  TripDTO trip;
    private  ClientDTO client;

    public RidesHistoryDTO(Integer id, TripDTO trip, ClientDTO client) {
        this.id = id;
        this.trip = trip;
        this.client = client;
    }

    public RidesHistoryDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public ClientDTO getClient() {
        return client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RidesHistoryDTO entity = (RidesHistoryDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.trip, entity.trip) &&
                Objects.equals(this.client, entity.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trip, client);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "trip = " + trip + ", " +
                "client = " + client + ")";
    }
}
