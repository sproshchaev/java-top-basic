package com.prosoft;

import java.util.Objects;

/**
 * (1) Класс Fish
 */
public class Fish {
    private String name;
    private double weight;
    private double price;

    public Fish(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
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
        Fish fish = (Fish) o;
        return Double.compare(fish.weight, weight) == 0 && Double.compare(fish.price, price) == 0
                && Objects.equals(name, fish.name);
    }

    /**
     * (1.2) Переопределение метода hashCode()
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price);
    }

    /**
     * (1.3) Переопределение метода toString()
     * @return
     */
    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
