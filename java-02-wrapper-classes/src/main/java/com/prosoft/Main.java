package com.prosoft;

/**
 * java-02-wrapper-classes
 *
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Слайд 19 Методы вида parseXXX преобразуют строку в значение примитивного типа
         */
        int i1 = Integer.parseInt("123");
        boolean b1 = Boolean.parseBoolean("TRUE");
        System.out.println( "i1=" + i1 + ", " + "b1=" + b1);

        /**
         * Метод valueOf преобразует строку или число в класс-обертку
         */
        Integer i2 = Integer.valueOf("5");
        Integer i3 = Integer.valueOf(7);
        Float f = Float.valueOf(1.3f);
        System.out.println( "i2=" + i2 + ", " + "i3=" + i3 + ", f=" + f);

        /**
         * Метод toBinaryString есть только у классов-оберток целых типов и преобразует число в строку бинарного вида
         */
        String binaryString = Integer.toBinaryString(21);
        System.out.println("binaryString=" + binaryString);

        /**
         * Метод hexString преобразует число в строку с 16-тиричным представлением
         */
        String hexString = Float.toHexString(1.5f);
        System.out.println("hexString=" + hexString);

        /**
         * Слайд 20 Статические методы класса-обертки Character
         */
        boolean isDigit1 = Character.isDigit('3');
        boolean isUpper = Character.isUpperCase('b');
        System.out.println("isDigit1=" + isDigit1 + ", isUpper=" + isUpper);

        /**
         * Слайд 21 Автоупаковка и распаковка
         * Без автоматической упаковки
         */
        Integer i4 = new Integer(5);

        /**
         * Автоматическая упаковка (autoboxing)
         */
        Integer i5 = 5;
        Boolean b = true;

        /**
         * Автоматическая распаковка (unboxing)
         */
        int i6 = new Integer(5);
        System.out.println("i4=" + i4 + ", i5=" + i5 + ", b=" + b + ", i6=" + i6);

    }

}
