package com.payment.payfareserver.utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientTrips {
    @JsonProperty("id")
    private int ridsHistoryId;
    @JsonProperty("carPlateNum")
    private String carPlateNum;
    @JsonProperty("driverPhone")
    private String driverPhone;
    @JsonProperty("amountPay")
    private Double amountPay;
    @JsonProperty("date")
    private LocalDateTime date;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;


    public ClientTrips() {
    }

    public ClientTrips(int ridsHistoryId, String carPlateNum, String driverPhone, Double amountPay, LocalDateTime date, String from, String to) {
        this.ridsHistoryId = ridsHistoryId;
        this.carPlateNum = carPlateNum;
        this.driverPhone = driverPhone;
        this.amountPay = amountPay;
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public int getRidsHistoryId() {
        return ridsHistoryId;
    }

    public void setRidsHistoryId(int ridsHistoryId) {
        this.ridsHistoryId = ridsHistoryId;
    }

    public String getCarPlateNum() {
        return carPlateNum;
    }

    public void setCarPlateNum(String carPlateNum) {
        this.carPlateNum = carPlateNum;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public Double getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(Double amountPay) {
        this.amountPay = amountPay;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
