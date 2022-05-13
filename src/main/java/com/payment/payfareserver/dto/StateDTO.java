package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;

public class StateDTO  {
    private  Integer id;
    private  String stateNameAr;
    private  String stateNameEn;
    private  Set<CityDTO> cities;

    public StateDTO(Integer id, String stateNameAr, String stateNameEn, Set<CityDTO> cities) {
        this.id = id;
        this.stateNameAr = stateNameAr;
        this.stateNameEn = stateNameEn;
        this.cities = cities;
    }

    public StateDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStateNameAr(String stateNameAr) {
        this.stateNameAr = stateNameAr;
    }

    public void setStateNameEn(String stateNameEn) {
        this.stateNameEn = stateNameEn;
    }

    public void setCities(Set<CityDTO> cities) {
        this.cities = cities;
    }

    public Integer getId() {
        return id;
    }

    public String getStateNameAr() {
        return stateNameAr;
    }

    public String getStateNameEn() {
        return stateNameEn;
    }

    public Set<CityDTO> getCities() {
        return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateDTO entity = (StateDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.stateNameAr, entity.stateNameAr) &&
                Objects.equals(this.stateNameEn, entity.stateNameEn) &&
                Objects.equals(this.cities, entity.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stateNameAr, stateNameEn, cities);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "stateNameAr = " + stateNameAr + ", " +
                "stateNameEn = " + stateNameEn + ", " +
                "cities = " + cities + ")";
    }
}
