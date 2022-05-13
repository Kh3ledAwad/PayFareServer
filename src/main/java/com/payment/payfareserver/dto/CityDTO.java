package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;

public class CityDTO  {
    private  Integer id;
    private  StateDTO state;
    private  String cityNameAr;
    private  String cityNameEn;
    private  Set<StationDTO> stations;

    public CityDTO(Integer id, StateDTO state, String cityNameAr, String cityNameEn, Set<StationDTO> stations) {
        this.id = id;
        this.state = state;
        this.cityNameAr = cityNameAr;
        this.cityNameEn = cityNameEn;
        this.stations = stations;
    }

    public CityDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setState(StateDTO state) {
        this.state = state;
    }

    public void setCityNameAr(String cityNameAr) {
        this.cityNameAr = cityNameAr;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    public void setStations(Set<StationDTO> stations) {
        this.stations = stations;
    }

    public Integer getId() {
        return id;
    }

    public StateDTO getState() {
        return state;
    }

    public String getCityNameAr() {
        return cityNameAr;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public Set<StationDTO> getStations() {
        return stations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO entity = (CityDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.state, entity.state) &&
                Objects.equals(this.cityNameAr, entity.cityNameAr) &&
                Objects.equals(this.cityNameEn, entity.cityNameEn) &&
                Objects.equals(this.stations, entity.stations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, cityNameAr, cityNameEn, stations);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "state = " + state + ", " +
                "cityNameAr = " + cityNameAr + ", " +
                "cityNameEn = " + cityNameEn + ", " +
                "stations = " + stations + ")";
    }
}
