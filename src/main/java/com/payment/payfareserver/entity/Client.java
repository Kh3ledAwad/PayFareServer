package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private User user;

    @Column(name = "wallet", nullable = false, precision = 15, scale = 2)
    private BigDecimal wallet;

    @OneToMany(mappedBy = "client")
    @Fetch(FetchMode.JOIN)
    @JsonBackReference
    private Set<RidesHistory> rideshistories = new LinkedHashSet<>();

    public Set<RidesHistory> getRideshistories() {
        return rideshistories;
    }

    public void setRideshistories(Set<RidesHistory> rideshistories) {
        this.rideshistories = rideshistories;
    }

    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", user=" + user +
                ", wallet=" + wallet +
                '}';
    }
}