package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id", nullable = false)
    private Integer id;

    @Column(name = "state_name_ar", nullable = false, length = 50)
    private String stateNameAr;

    @Column(name = "state_name_en", nullable = false, length = 50)
    private String stateNameEn;

    @OneToMany(mappedBy = "state")
    @JsonBackReference
    private Set<City> cities = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateNameAr() {
        return stateNameAr;
    }

    public void setStateNameAr(String stateNameAr) {
        this.stateNameAr = stateNameAr;
    }

    public String getStateNameEn() {
        return stateNameEn;
    }

    public void setStateNameEn(String stateNameEn) {
        this.stateNameEn = stateNameEn;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

}