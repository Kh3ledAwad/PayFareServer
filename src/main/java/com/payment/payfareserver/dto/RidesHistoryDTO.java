package com.payment.payfareserver.dto;

import java.util.Objects;

public class RidesHistoryDTO  {
    private  Integer id;
    private  TripDTO trip;
    private  ClientDTO client;
    private Double amountPay ;

    public RidesHistoryDTO(Integer id, TripDTO trip, ClientDTO client, Double amountPay) {
        this.id = id;
        this.trip = trip;
        this.client = client;
        this.amountPay = amountPay;
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

    public Double getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(Double amountPay) {
        this.amountPay = amountPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RidesHistoryDTO)) return false;
        RidesHistoryDTO that = (RidesHistoryDTO) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTrip(), that.getTrip()) && Objects.equals(getClient(), that.getClient()) && Objects.equals(getAmountPay(), that.getAmountPay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTrip(), getClient(), getAmountPay());
    }

    @Override
    public String toString() {
        return "RidesHistoryDTO{" +
                "id=" + id +
                ", trip=" + trip +
                ", client=" + client +
                ", amountPay=" + amountPay +
                '}';
    }
}
