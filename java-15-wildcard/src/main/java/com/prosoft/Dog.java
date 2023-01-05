package com.prosoft;

/**
 * (4) Класс Dog Собака является наследником класса Pet
 */
public class Dog extends Pet {

    public void wow() {
        System.out.println("Dog.wow()");
    }

    @Override
    public String toString() {
        return "Dog{}";
    }
}
