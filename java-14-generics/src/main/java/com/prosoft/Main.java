package com.prosoft;

/**
 * java-14-generics
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (2) Создание экземпляра класса
         */
        SimplePrinter simplePrinter = new SimplePrinter();

        /**
         * Вызов метода print() с аргументом типа int
         */
        simplePrinter.print(10);

        /**
         * Вызов метода print(int digit) с аргументом типа double
         */
        simplePrinter.print(10.0);

        /**
         * Вызов метода print(String str) с аргументом типа String
         */
        simplePrinter.print("10.00");

        /**
         * Вызов метода print(Object obj) с аргументом типа Object
         */
        Long l1 = 10L;
        simplePrinter.print(l1);

        Integer i1 = 1000;
        simplePrinter.print(i1);

        /**
         * (4) Использование Generic - один метод print2() на все виды аргументов
         */
        System.out.println("Использование Generic:");

        simplePrinter.print2(10); // аргумент типа int

        simplePrinter.print2(10.0); // аргумент типа double

        simplePrinter.print2("10.00"); // аргумент типа String

        Long l2 = 10L;
        simplePrinter.print2(l2); // аргумент типа Object

        Integer i2 = 1000;
        simplePrinter.print2(i2); // аргумент типа Object

    }
}
