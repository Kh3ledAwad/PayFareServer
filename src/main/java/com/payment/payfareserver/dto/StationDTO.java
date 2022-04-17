package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by khaledawad on 4/13/2022.
 */
public class StationDTO  {
    private  Integer id;
    private  CityDTO city;
    private  String name;
    private  Set<TrafficDTO> traffic;
    private  Set<CarDTO> cars;
    private  Set<AdminDTO> admins;

    public StationDTO(Integer id, CityDTO city, String name, Set<TrafficDTO> traffic, Set<CarDTO> cars, Set<AdminDTO> admins) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.traffic = traffic;
        this.cars = cars;
        this.admins = admins;
    }

    public StationDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTraffic(Set<TrafficDTO> traffic) {
        this.traffic = traffic;
    }

    public void setCars(Set<CarDTO> cars) {
        this.cars = cars;
    }

    public void setAdmins(Set<AdminDTO> admins) {
        this.admins = admins;
    }

    public Integer getId() {
        return id;
    }

    public CityDTO getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public Set<TrafficDTO> getTraffic() {
        return traffic;
    }

    public Set<CarDTO> getCars() {
        return cars;
    }

    public Set<AdminDTO> getAdmins() {
        return admins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationDTO entity = (StationDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.traffic, entity.traffic) &&
                Objects.equals(this.cars, entity.cars) &&
                Objects.equals(this.admins, entity.admins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, name, traffic, cars, admins);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "city = " + city + ", " +
                "name = " + name + ", " +
                "traffic = " + traffic + ", " +
                "cars = " + cars + ", " +
                "admins = " + admins + ")";
    }
}
