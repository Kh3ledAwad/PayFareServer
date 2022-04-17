package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @JsonManagedReference
    private City city;

    @Column(name = "name", nullable = false, length = 225)
    private String name;

    @OneToMany(mappedBy = "station")
    @JsonBackReference
    private Set<Traffic> traffic = new LinkedHashSet<>();

    @OneToMany(mappedBy = "mainStation")
    @JsonBackReference
    private Set<Car> cars = new LinkedHashSet<>();

    @OneToMany(mappedBy = "station")
    @JsonBackReference
    private Set<Admin> admins = new LinkedHashSet<>();

    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Traffic> getTraffic() {
        return traffic;
    }

    public void setTraffic(Set<Traffic> traffic) {
        this.traffic = traffic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}