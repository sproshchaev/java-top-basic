package com.prosoft;

/**
 * java-06-methods
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Слайд 49 Методы. Передача параметров
         */
        Main main = new Main();
        Integer i = 10;
        main.myMethod(i);
        System.out.println( "i=" + i);

        /**
         * Слайд 55 Методы. Рекурсия
         */
        int k = 5;
        double result = main.fact(k);
        System.out.println("Factorial " + k + " is equal " + result);

    }

    /**
     * Метод класса myMethod
     * @param i
     */
    private void myMethod(Integer i) {
        System.out.println("myMethod получил аргумент " + i);
        i = i + 1;
        System.out.println("myMethod изменил аргумент " + i);
    }

    /**
     * Метод fact() вычисления факториала
     * @param n
     * @return
     */
    private double fact(int n) {
        if (n <= 1) return 1;
        return fact(n-1) * n;
    }

}
