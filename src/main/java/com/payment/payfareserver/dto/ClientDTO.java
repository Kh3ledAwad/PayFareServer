package com.payment.payfareserver.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * Created by khaledawad on 4/13/2022.
 */
public class ClientDTO {
    private  Integer id;
    private  UserDTO user;
    private  BigDecimal wallet;
    private  Set<RidesHistoryDTO> rideshistories;

    public ClientDTO(Integer id, UserDTO user, BigDecimal wallet, Set<RidesHistoryDTO> rideshistories) {
        this.id = id;
        this.user = user;
        this.wallet = wallet;
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

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
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

    public BigDecimal getWallet() {
        return wallet;
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
                Objects.equals(this.wallet, entity.wallet) &&
                Objects.equals(this.rideshistories, entity.rideshistories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, wallet, rideshistories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "user = " + user + ", " +
                "wallet = " + wallet + ", " +
                "rideshistories = " + rideshistories + ")";
    }
}
