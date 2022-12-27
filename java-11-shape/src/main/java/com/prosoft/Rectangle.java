package com.prosoft;

/**
 * Класс Прямоугольник создан на основе абстрактного класса Shape
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
     * @param color
     * @param length
     * @param width
     */
    public Rectangle(int length, int width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }

    /**
     * Переопределение метода getArea() из абстрактного класса Shape
     *
     * @return
     */
    @Override
    public double getArea() {
        return length * width;
    }
}
