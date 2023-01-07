package com.prosoft;

import java.util.Objects;

/**
 * (1) Класс Car
 */
public class Car {
    private String brand;
    private String color;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    /**
     * (1.1) Переопределение метода equals()
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
     * (1.2) Переопределение метода hashCode()
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, color);
    }

    /**
     * (1.3) Переопределение метода toString()
     * @return
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
