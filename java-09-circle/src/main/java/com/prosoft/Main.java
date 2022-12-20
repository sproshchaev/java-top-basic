package com.prosoft;

/**
 * java-09-circle
 *
 */
public class Main
{
    public static void main(String[] args) {

        Circle c1 = new Circle(2.0, "blue");
        Circle c2 = new Circle(2.0, "red");
        Circle c3 = new Circle(1.0, "red");

        System.out.println( "c1: radius=" + c1.getRadius() + ", color= " +  c1.getColor());
        System.out.println( "c2: radius=" + c2.getRadius() + ", color= " +  c2.getColor());
        System.out.println( "c3: radius=" + c3.getRadius() + ", color= " +  c3.getColor());

    }
}
