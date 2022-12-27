package com.prosoft;

/**
 * Класс Shape - абстрактный класс, содержащий абстрактный метод getArea()
 */
abstract public class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    /**
     * Абстрактный метод getArea()
     * @return
     */
    abstract public double getArea();

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }
}
