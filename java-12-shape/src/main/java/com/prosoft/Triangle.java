package com.prosoft;

/**
 * Класс Треугольник реализующий интерфейс Shape
 */
public class Triangle implements Shape {
    /**
     * Поле класса Основание
     */
    private int base;
    /**
     * Поле класса Высота
     */
    private int height;
    /**
     * Поле класса Цвет
     */
    private String color;

    /**
     * Конструктор класса
     */
    public Triangle(int base, int height, String color) {
        this.base = base;
        this.height = height;
        this.color = color;
    }

    /**
     * Метод getArea()
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
                ", color='" + color + '\'' +
                '}';
    }
}
