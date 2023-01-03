package com.prosoft;

/**
 * java-14-generics
 *
 */
public class Main {
    public static void main(String[] args) {

        // (2) вывод
        SimplePrinter simplePrinter = new SimplePrinter();

        // int
        simplePrinter.print(10);
        // double
        simplePrinter.print(10.0);
        // str
        simplePrinter.print("10.00");
        // Obj
        Long l1 = 10L;
        simplePrinter.print(l1);
        Integer i1 = 1000;
        simplePrinter.print(i1);

        // (4) вывод через Generic
        System.out.println("Использование Generic:");

        // int
        simplePrinter.print2(10);
        // double
        simplePrinter.print2(10.0);
        // str
        simplePrinter.print2("10.00");
        // Obj
        simplePrinter.print2(l1);
        simplePrinter.print2(i1);

    }
}
