package com.prosoft;

/**
 * Класс Shape (Геометрическая фигура)
 */
public class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public double getArea() {
        System.out.println("");
        return 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }
}
