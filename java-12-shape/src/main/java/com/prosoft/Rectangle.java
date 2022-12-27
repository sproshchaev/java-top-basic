package com.prosoft;

/**
 * Класс Прямоугольник реализующий интерфейс Shape
 */
public class Rectangle implements Shape {
    /**
     * Поле класса Длина
     */
    private int length;
    /**
     * Поле класса Ширина
     */
    private int width;
    /**
     * Поле класса Цвет
     */
    private String color;

    /**
     * Конструктор класса
     *
     * @param length
     * @param width
     * @param color
     */
    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    /**
     * Метод getArea()
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
                ", color='" + color + '\'' +
                '}';
    }
}
