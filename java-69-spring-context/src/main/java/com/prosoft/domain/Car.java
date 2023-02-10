package com.prosoft.domain;

import java.util.Objects;

/**
 * (1) Класс Car созданный по правилам JavaBeans
 * Экземпляры класса добавляется в контекст через аннотацию @Bean в AppConfig.class
 */
public class Car {
    private long id;
    private String brand;
    private String color;

    public Car() {
    }

    public Car(String brand, String color) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color);
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
