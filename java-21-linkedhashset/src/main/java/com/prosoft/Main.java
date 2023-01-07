package com.prosoft;

import java.util.LinkedHashSet;

/**
 * java-21-linkedhashset
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (2) Создание коллекции LinkedHashSet
         */
        LinkedHashSet<Car> carLinkedHashSet = new LinkedHashSet<>();

        /**
         * (3) Добавление элементов. Порядок элементов может соответствует порядку добавления
         */
        carLinkedHashSet.add(new Car("audi","black"));
        carLinkedHashSet.add(new Car("fiat","green"));
        carLinkedHashSet.add(new Car("mercedes","white"));

        System.out.println("HashSet size=" + carLinkedHashSet.size() + ": " + carLinkedHashSet);

        /**
         * (4) Добавление существующего элемента не изменяет размер коллекции
         */
        System.out.println("Add 'audi': " + carLinkedHashSet.add(new Car("audi","black")));

        /**
         * (5) Перебор элементов коллекции через цикл for-each
         */
        for (Car car : carLinkedHashSet) {
            System.out.println(car.toString());
        }




    }
}
