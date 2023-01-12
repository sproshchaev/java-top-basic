package com.prosoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * java-28-synchronizedlist
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание синхронизированной коллекции ArrayList
         */
        List<Object> synchronizedArrayList = Collections.synchronizedList(new ArrayList<>());

        /**
         * (2) Добавление элементов в коллекцию. Метод add()
         */
        synchronizedArrayList.add("Argentina");
        synchronizedArrayList.add("Bulgaria");
        synchronizedArrayList.add("Canada");
        synchronizedArrayList.add("Denmark");
        synchronizedArrayList.add("Narnia");

        System.out.println("Collection Using Iterator:");

        /**
         * (3) Использование оператора synchronized() для синхронизации итератора, проходящего по синхронизированной
         * коллекции
         */
        synchronized (synchronizedArrayList) {
            Iterator<Object> iter = synchronizedArrayList.iterator();
            int count = 0;
            while (iter.hasNext()) {
                System.out.println(++count + ") " + iter.next());
            }
        }
    }
}
