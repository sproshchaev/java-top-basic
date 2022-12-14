package com.prosoft;

/**
 * Класс Треугольник
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
     * @param base
     * @param height
     * @param color
     */
    public Triangle(int base, int height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    /**
     * Переопределение метода getArea() абстрактного класса Shape
     *
     * @return
     */
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    /**
     * Переопределение метода toString класса Object
     *
     * @return
     */
    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", subclass=" + super.toString() +
                '}';
    }
}
