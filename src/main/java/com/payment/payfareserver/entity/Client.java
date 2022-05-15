package com.payment.payfareserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
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
    @JoinColumn(name = "user_id", nullable = false,unique = true)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private User user;

    @Column(name = "amount", precision = 15, scale = 2)
    private Double amount;

    @OneToMany(mappedBy = "client")
    @Fetch(FetchMode.JOIN)
    @JsonBackReference
    private Set<RidesHistory> ridesHistories = new LinkedHashSet<>();

    public Set<RidesHistory> getRidesHistories() {
        return ridesHistories;
    }

    public void setRidesHistories(Set<RidesHistory> ridesHistories) {
        this.ridesHistories = ridesHistories;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double wallet) {
        this.amount = wallet;
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
                ", wallet=" + amount +
                '}';
    }
}