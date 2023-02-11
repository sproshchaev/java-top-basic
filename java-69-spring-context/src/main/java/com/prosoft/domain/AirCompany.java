package com.prosoft.domain;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * (9) Класс Ship созданный по правилам JavaBeans
 */
@Component
public class AirCompany {
    private long id;
    private String name;

    public AirCompany() {
    }

    public AirCompany(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCompany that = (AirCompany) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "AirCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
