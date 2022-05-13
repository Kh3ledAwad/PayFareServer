package com.payment.payfareserver.dto;

import java.util.Objects;
import java.util.Set;

/**
 * Created by khaledawad on 4/13/2022.
 */
public class TypeDTO  {
    private  Integer id;
    private  String name;
    private  Set<UserDTO> users;

    public TypeDTO(Integer id, String name, Set<UserDTO> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public TypeDTO() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<UserDTO> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDTO entity = (TypeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.users, entity.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "users = " + users + ")";
    }
}
