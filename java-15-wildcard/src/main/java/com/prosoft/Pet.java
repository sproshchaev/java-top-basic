package com.prosoft;

/**
 * (2) Класс Pet Питомец является наследником класса Animal
 */
public class Pet extends Animal {
    public void call() {
        System.out.println("Pet.call()");
    }

    @Override
    public String toString() {
        return "Pet{}";
    }
}
