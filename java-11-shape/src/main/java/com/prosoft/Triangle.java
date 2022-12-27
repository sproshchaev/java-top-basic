package com.prosoft;

/**
 * Класс Треугольник создан на основе абстрактного класса Shape
 */
public class Triangle extends Shape {
    /**
     * Поле класса Основание
     */
    private int base;
    /**
     * Поле класса Высота
     */
    private int height;

    /**
     * Конструктор класса
     *
     * @param color
     * @param base
     * @param height
     */
    public Triangle(int base, int height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    /**
     * Переопределение метода getArea() из абстрактного класса Shape
     *
     * @return
     */
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
