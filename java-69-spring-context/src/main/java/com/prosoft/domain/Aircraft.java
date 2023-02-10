package com.prosoft.domain;

import java.util.Objects;

/**
 * (1.2) Класс Aircraft созданный по правилам JavaBeans
 * Экземпляры класса добавляется в контекст через аннотацию @Bean в AppConfig.class
 */
public class Aircraft {
    private long id;
    private String brand;
    private String airCompany;

    public Aircraft() {
    }

    public Aircraft(String brand, String airCompany) {
        this.brand = brand;
        this.airCompany = airCompany;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAirCompany() {
        return airCompany;
    }

    public void setAirCompany(String airCompany) {
        this.airCompany = airCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return id == aircraft.id && Objects.equals(brand, aircraft.brand) && Objects.equals(airCompany, aircraft.airCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, airCompany);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", airCompany='" + airCompany + '\'' +
                '}';
    }
}
