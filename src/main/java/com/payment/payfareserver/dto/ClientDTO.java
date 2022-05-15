package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;

/**
 * Created by khaledawad on 4/13/2022.
 */
public class ClientDTO {
    private  Integer id;
    private  UserDTO user;
    private  Double amount;
    private  Set<RidesHistoryDTO> rideshistories;

    public ClientDTO(Integer id, UserDTO user, Double wallet, Set<RidesHistoryDTO> rideshistories) {
        this.id = id;
        this.user = user;
        this.amount = wallet;
        this.rideshistories = rideshistories;
    }

    public ClientDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setRideshistories(Set<RidesHistoryDTO> rideshistories) {
        this.rideshistories = rideshistories;
    }

    public Integer getId() {
        return id;
    }

    public UserDTO getUser() {
        return user;
    }

    public Double getAmount() {
        return amount;
    }

    public Set<RidesHistoryDTO> getRideshistories() {
        return rideshistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO entity = (ClientDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.amount, entity.amount) &&
                Objects.equals(this.rideshistories, entity.rideshistories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, amount, rideshistories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "user = " + user + ", " +
                "wallet = " + amount + ", " +
                "rideshistories = " + rideshistories + ")";
    }
}
