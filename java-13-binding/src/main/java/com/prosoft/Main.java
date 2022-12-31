package com.prosoft;

/**
 * java-13-binding
 *
 */
public class Main {
    public static void main(String[] args) {
        newObject(new Object());
        newObject(new Person());
        newObject(new Student());
        newObject(new Engineer());
    }

    public static void newObject(Object object) {
        System.out.println(object.toString());
    }

}
