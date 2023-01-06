package com.prosoft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * java-18-arraylist
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекцию ArrayList с элементами типа String
         */
        List<String> stringList = new ArrayList<>();

        /**
         * (2) Заполнение коллекции элементами. Метод add()
         */
        stringList.add("Argentina");
        stringList.add("Bulgaria");
        stringList.add("Canada");
        stringList.add("Denmark");
        stringList.add("Narnia");

        /**
         * (3) Вывод элементов коллекции
         */
        System.out.println("Collection: " + stringList);

        /**
         * (4) Число элементов коллекции. Метод size()
         */
        System.out.println("Collection's size: " + stringList.size());

        /**
         * (5) Получение первого элемента коллекции с индексом 0. Метод get()
         */
        System.out.println("First item: " + stringList.get(0));

        /**
         * (6) Проверка наличия элемента в коллекции. Метод contains()
         */
        System.out.println("Contains 'Denmark': " + stringList.contains("Denmark"));

        /**
         * (7) Изменение заданного элемента. Метод set()
         */
        stringList.set(2, "CANADA");
        System.out.println("Third item: " + stringList.get(2));

        /**
         * (8) Получение номера элемента по значению (первый элемент - индекс 0, не найден -1). Метод indexOf()
         */
        System.out.println("Index of 'England' =" + stringList.indexOf("England"));
        System.out.println("Index of 'Bulgaria' =" + stringList.indexOf("Bulgaria"));

        /**
         * (9) Усечени емкости коллекции Capacity до текущего количества элементов. Метод trimToSize()
         * При использовании интерфейса ArrayList<...>
         */
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(35);
        intList.add(20);
        intList.add(25);
        intList.trimToSize();

        /**
         * (10) Установка емкости коллекции в требуемом размере. Метод ensureCapacity()
         * При использовании интерфейса ArrayList<...>
         */
        intList.ensureCapacity(100);

        /**
         * (11) Преобразование коллекции в массив объектов. Метод toArray() возвращает Object[]
         */
        Object[] intArray = intList.toArray();
        Object[] stringArray = stringList.toArray();

        /**
         * (12) Слияние коллекций. Метод addAll()
         */
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("Ukraine");
        stringList2.add("Japan");
        stringList.addAll(stringList2);
        System.out.println(stringList);

        /**
         * (13) Перебор элементов коллекции через цикл for
         */
        for (int i = 0; i < stringList.size(); i++) {
            System.out.print(stringList.get(i) + ", ");
        }
        System.out.println("");

        /**
         * (14) Перебор элементов коллекции через цикл for-each
         */
        for (String item : stringList) {
            System.out.print(item + ", ");
        }
        System.out.println("");

        /**
         * (15) Перебор элементов коллекции через цикл while
         */
        int i = 0;
        while (i < stringList.size()) {
            System.out.print(stringList.get(i) + ", ");
            i++;
        }
        System.out.println("");

        /**
         * (16) Перебор элементов коллекции через Iterator в одном направлении
         */
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println("");

        /**
         * (17) Перебор элементов коллекции через ListIterator в прямом и обратном направлении
         */
        ListIterator<String> listIterator = stringList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }
        System.out.println("");

        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ", ");
        }
        System.out.println("");

        /**
         * (18) Перебор элементов коллекции через Stream API
         */
        stringList.forEach(s -> {
            System.out.print(s + ", ");
        });
        System.out.println("");

    }
}
