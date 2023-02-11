package com.prosoft.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * (10) Класс Ticket содержит внедрение бина AirCompany через аннотацию @Autowired в конструкторе класса
 */
@Component
public class Ticket {
    private long id;
    private final AirCompany airCompany;

    @Autowired
    public Ticket(AirCompany airCompany) {
        this.airCompany = airCompany;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AirCompany getAirCompany() {
        return airCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Objects.equals(airCompany, ticket.airCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airCompany);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", airCompany=" + airCompany +
                '}';
    }
}
