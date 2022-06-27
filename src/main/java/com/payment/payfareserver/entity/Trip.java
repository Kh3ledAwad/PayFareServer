package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", nullable = false)
    private Integer id;

    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime date;

    @Column(name = "price", nullable = false, precision = 15, scale = 2)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "admin_id", nullable = false)
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "traffic_id", nullable = false)
    @JsonManagedReference
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private Traffic traffic;

    @OneToMany(mappedBy = "trip")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<RidesHistory> ridesHistories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "trip")
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private Set<Blockchain> block = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @JsonIgnore
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    @JsonIgnore
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    @JsonIgnore
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    @JsonIgnore
    public Traffic getTraffic() {
        return traffic;
    }

    public void setTraffic(Traffic traffic) {
        this.traffic = traffic;
    }

    public Set<RidesHistory> getRidesHistories() {
        return ridesHistories;
    }

    public void setRidesHistories(Set<RidesHistory> ridesHistories) {
        this.ridesHistories = ridesHistories;
    }
}