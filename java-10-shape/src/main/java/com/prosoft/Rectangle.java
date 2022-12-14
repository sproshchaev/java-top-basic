package com.prosoft;

/**
 * Класс Прямоугольник
 */
public class Rectangle extends Shape {
    /**
     * Поле класса Длина
     */
    private int length;
    /**
     * Поле класса Ширина
     */
    private int width;

    /**
     * Конструктор класса
     *
     * @param length
     * @param width
     * @param color
     */
    public Rectangle(int length, int width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }

    /**
     * Переопределение метода getArea() класса Shape
     *
     * @return
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * Переопределение метода toString() класса Object
     *
     * @return
     */
    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", color=" + super.getColor() +
                '}';
    }
}
