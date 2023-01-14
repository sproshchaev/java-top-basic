package com.prosoft;

import java.util.Objects;

/**
 * Класс Car
 */
public class Car {
    private String brand;
    private String color;
    private int price;

    public Car(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
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
        return price == car.price && Objects.equals(brand, car.brand) && Objects.equals(color, car.color);
    }

    /**
     * Переопределение метода hashCode()
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price);
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
                ", price=" + price +
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
