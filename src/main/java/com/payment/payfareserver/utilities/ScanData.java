package com.payment.payfareserver.utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScanData {
    @JsonProperty("carId")
    private int carId;
    @JsonProperty("price")
    private double price;
    @JsonProperty("driverPhone")
    private String driverPhone;

    public ScanData() {
    }

    public ScanData(int carId, double price, String driverPhone) {
        this.carId = carId;
        this.price = price;
        this.driverPhone = driverPhone;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
}
