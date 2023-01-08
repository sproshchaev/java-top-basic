package com.prosoft;

import java.util.Objects;

/**
 * (4) Класс Car
 */
public class Car implements Comparable<Car> {
    private String brand;
    private String color;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    /**
     * (4.1) Переопределение метода compareTo() у интерфейса Comparable
     */
    @Override
    public int compareTo(Car car) {
        return this.brand.compareTo(car.getBrand());
    }

    /**
     * Переопределение метода equals()
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    /**
     * Переопределение метода hashCode()
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, color);
    }

    /**
     * Переопределение метода toString()
     * @return
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
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
