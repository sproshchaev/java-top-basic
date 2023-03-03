package com.prosoft.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Класс Car
 */
@Entity
public class Car {

    @Id
    @GeneratedValue
    private long id;
    private String brand;
    private String color;

    public Car() {
    }

    public Car(long id) {
        this.id = id;
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public Car(long id, String brand, String color) {
        this.id = id;
        this.brand = brand;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
