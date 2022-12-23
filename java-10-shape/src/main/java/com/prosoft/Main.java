package com.prosoft;

/**
 * java-10-shape
 *
 */
public class Main {
    public static void main(String[] args) {

        Shape shape = new Triangle( 10, 10, "blue");
        System.out.println("Triangle. Площадь: " + shape.getArea());

        Shape shape2 = new Rectangle(20, 20, "white");
        System.out.println("Rectangle. Площадь: " + shape2.getArea());

    }
}
