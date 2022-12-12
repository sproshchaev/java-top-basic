package com.prosoft;

import java.util.Arrays;

/**
 * java-07-arrays
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Слайд 67. Массивы. Ссылка на массив
         */
        int[] myIntArray; // 1-ый вариант объявления массива

        int myIntArray2[]; // 2-ой вариант объявления массива

        /**
         * Слайд 68. Массивы. Создание объекта массива
         */
        myIntArray = new int[3];

        int[] myIntArray3 = new int[3];

        /**
         * Слайд 69. Массивы. Методы для работы с массивами
         */
        int[] myIntArray4 = {5, 2, 3, 0, 1, 4}; // упрощенная инициализация элементов массива

        System.out.println("Длина массива myIntArray4=" + myIntArray4.length);

        for (int i = 0; i < myIntArray4.length; i++) {
            System.out.println("Элемент " + i + "=" + myIntArray4[i]);
        }

        Arrays.sort(myIntArray4);

        System.out.println("Одномерный массив. Элементы после сортировки:");
        for (int i = 0; i < myIntArray4.length; i++) {
            System.out.println("Элемент " + i + "=" + myIntArray4[i]);
        }

        /**
         * Слайд 70. Многомерные массивы
         */
        System.out.println("Двумерный массив:");
        int[][] myIntArray5 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        for (int i = 0; i < myIntArray5.length; i++) {
            for (int j = 0; j < myIntArray5[i].length; j++) {
                System.out.println("Элемент [" + i + "][" + j + "]=" + myIntArray5[i][j]);
            }
        }

        /**
         * Слайд 71. Вывод элементов через for-each
         */
        System.out.println("Одномерный массив. Вывод элементов через for-each:");
        long[] myLongArray = {10L, 20L, 30L, 40L, 50L};
        int count = 0;
        for (long item : myLongArray) {
            count++;
            System.out.println("Элемент " + count + "=" + item);
        }

        /**
         * Слайд 73. Массивы. Копирование
         */
        System.out.println("Элементы скопированного массива:");
        char[] myCharArray = {'H', 'e', 'l', 'l', 'o', '!'};
        char[] myCharArray2 = new char[6];
        System.arraycopy(myCharArray, 0, myCharArray2, 0, 6);
        int count2 = 0;
        for (char item : myCharArray2) {
            count2++;
            System.out.println("Элемент " + count2 + "=" + item);
        }

        /**
         * Слайд 74. Массивы. Класс java.util.Arrays. Метод toString()
         */
        boolean[] myBoolArray = {true, false, true};
        System.out.println("Элементы массива через .toString: " + Arrays.toString(myBoolArray));

        /**
         * Слайд 75. Массивы. Класс java.util.Arrays. Метод fill()
         */
        int[] myIntArray6 = new int[10];
        int startIndex = 1;
        int endIndex = 4;
        Arrays.fill(myIntArray6, startIndex, endIndex, 2);
        System.out.println("Элементы заполненного массива через .fill: " + Arrays.toString(myIntArray6));

        /**
         * Слайд 76. Массивы. Класс java.util.Arrays. Метод sort()
         */
        Arrays.sort(myIntArray6);
        System.out.println("Элементы отсортированного массива через .sort: " + Arrays.toString(myIntArray6));

        /**
         * Слайд 77. Массивы. Класс java.util.Arrays. Метод equals()
         */
        System.out.println("Сравнение массивов:");
        int[] myIntArray7 = {1, 2, 3};
        System.out.println("myIntArray7=" + Arrays.toString(myIntArray7));

        int[] myIntArray8 = {1, 2, 3};
        System.out.println("myIntArray8=" + Arrays.toString(myIntArray8));

        int[] myIntArray9 = {3, 2, 1};
        System.out.println("myIntArray9=" + Arrays.toString(myIntArray9));

        System.out.println("myIntArray7 и myIntArray8: " + Arrays.equals(myIntArray7, myIntArray8));

        System.out.println("myIntArray7 и myIntArray9: " + Arrays.equals(myIntArray7, myIntArray9));

    }
}
