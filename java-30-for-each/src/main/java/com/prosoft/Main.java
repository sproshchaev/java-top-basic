package com.prosoft;

import java.util.ArrayList;
import java.util.List;

/**
 * java-30-for-each
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создать коллекцию ArrayList() и заполнить ее произвольными элементами типа Integer
         */
        List<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(11);
        integerArrayList.add(5);
        integerArrayList.add(120);
        integerArrayList.add(85);
        integerArrayList.add(251);
        integerArrayList.add(199);

        /**
         * (2) Вывести элементы коллекции ArrayList() в консоль используя метод forEach()
         */
        integerArrayList.forEach(item -> System.out.println(item));
        System.out.println("");

        /**
         * (3) Изменение элементов коллекции: если элемент > 100, то делится на 10
         */
        integerArrayList.forEach(item -> {
            if (item > 100) {
                int index = integerArrayList.indexOf(item);
                integerArrayList.set(index, item / 10);
            }
        });
        System.out.println("After:");
        integerArrayList.forEach(item -> System.out.println(item));

    }
}
