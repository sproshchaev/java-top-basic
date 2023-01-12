package com.prosoft;

import java.util.Objects;

/**
 * Класс Car
 */
public class Car {
    private long id;
    private String brand;
    private String color;

    /**
     * Конструктор класса
     *
     * @param id
     * @param brand
     * @param color
     */
    public Car(long id, String brand, String color) {
        this.id = id;
        this.brand = brand;
        this.color = color;
    }

    /**
     * Переопределение метода equals()
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    /**
     * Переопределение метода hashCode()
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color);
    }

    /**
     * Переопределение метода toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
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
}
