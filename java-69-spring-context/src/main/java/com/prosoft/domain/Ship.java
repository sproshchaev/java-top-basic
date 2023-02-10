package com.prosoft.domain;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * (6) Класс Ship созданный по правилам JavaBeans
 * Экземпляры класса добавляется в контекст через стереотипную аннотацию @Component и @ComponentScan.
 * Работает с версией Java не ниже 11
 */
@Component
public class Ship {
    private long id;
    private String name;
    private String country;

    public Ship() {
    }

    public Ship(String name, String country) {
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return id == ship.id && Objects.equals(name, ship.name) && Objects.equals(country, ship.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

