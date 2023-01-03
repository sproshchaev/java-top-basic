package com.prosoft;

public class SimplePrinter {

    // (1)
    public void print(int digit) {
        System.out.println("Вывод: " + digit);
    }

    public void print(double digit) {
        System.out.println("Вывод: " + digit);
    }

    public void print(String str) {
        System.out.println("Вывод: " + str);
    }

    public void print(Object obj) {
        System.out.println("Вывод: " + obj.toString());
    }

    // (3) использование Generic
    public <T> void print2(T digit) {
        System.out.println("Вывод: " + digit);
    }

}
