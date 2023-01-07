package com.prosoft;

import java.util.HashSet;

/**
 * java-20-hashset
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (2) Создание коллекции HashSet
         */
        HashSet<Fish> fishHashSet = new HashSet<>();

        /**
         * (3) Добавление элементов. Порядок элементов может не соответствовать порядку добавления
         */
        fishHashSet.add(new Fish("eel",1.5,120));
        fishHashSet.add(new Fish("salmon",2.5,180));
        fishHashSet.add(new Fish("carp",3.5,80));
        fishHashSet.add(new Fish("trout",2.2,150));

        System.out.println("HashSet size=" + fishHashSet.size() + ": " + fishHashSet);

        /**
         * (4) Добавление существующего элемента не изменяет размер коллекции
         */
        System.out.println("Add 'eel': " + fishHashSet.add(new Fish("eel",1.5,120)));

        /**
         * (5) Перебор элементов коллекции через цикл for-each
         */
        for (Fish fish : fishHashSet) {
            System.out.println(fish.toString());
        }

    }
}
