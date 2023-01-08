package com.prosoft;

import java.util.TreeSet;

/**
 * java-22-treeset
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекции TreeSet из строковых элементов
         */
        TreeSet<String> stringTreeSet = new TreeSet<>();

        /**
         * (2) Добавление элементов. Коллекция TreeSet всегда содержит элементы в отсортированном по возрастанию порядке
         */
        stringTreeSet.add("Georgia");
        stringTreeSet.add("Argentina");
        stringTreeSet.add("Ukraine");
        stringTreeSet.add("Belgium");
        stringTreeSet.add("Canada");

        System.out.println("TreeSet size=" + stringTreeSet.size() + ": " + stringTreeSet);

        /**
         * (3) Создание коллекции TreeSet из элементов класса Car в котором используется интерфейс Comparable
         */
        TreeSet<Car> carTreeSet = new TreeSet<>();

        /**
         * (5) Добавление элементов. Порядок элементов будет соответствовать логике, определенной в методе compareTo
         * класса Car (см.4.1)
         */
        carTreeSet.add(new Car("mercedes","white"));
        carTreeSet.add(new Car("audi","black"));
        carTreeSet.add(new Car("fiat","green"));

        System.out.println("TreeSet size=" + carTreeSet.size() + ": " + carTreeSet);

        /**
         * (6) Создание коллекции TreeSet из элементов класса Fish:
         * (6.1) Создание экземпляра класса FishComparator
         */
        FishComparator fishComparator = new FishComparator();

        /**
         * (6) Создание коллекции TreeSet из элементов класса Fish:
         * (6.2) Передача в конструктор класса TreeSet экземпляра класса FishComparator
         */
        TreeSet<Fish> fishTreeSet = new TreeSet<>(fishComparator);

        /**
         * (7) Добавление элементов. Порядок элементов определеяется логикой, определенной в FishComparator
         * (см.6.3)
         */
        fishTreeSet.add(new Fish("eel",1.5,120));
        fishTreeSet.add(new Fish("salmon",2.5,180));
        fishTreeSet.add(new Fish("carp",3.5,80));
        fishTreeSet.add(new Fish("trout",2.2,150));

        System.out.println("TreeSet size=" + fishTreeSet.size() + ": " + fishTreeSet);



    }
}
