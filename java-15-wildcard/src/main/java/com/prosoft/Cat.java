package com.prosoft;

/**
 * (3) Класс Cat Кошка является наследником класса Pet
 */
public class Cat extends Pet {

    public void meow() {
        System.out.println("Cat.meow()");
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}
