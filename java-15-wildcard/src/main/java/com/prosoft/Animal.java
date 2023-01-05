package com.prosoft;

/**
 * (1) Класс Animal животные (по умолчанию является наследником класса Object, как любой класс в Java)
 */
public class Animal {

    public void feed() {
        System.out.println("Animal.feed()");
    }

    @Override
    public String toString() {
        return "Animal{}";
    }
}
