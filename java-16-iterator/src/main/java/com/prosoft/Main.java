package com.prosoft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * java-16-iterator
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Заполнение элементов списка ArrayList
         */
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(i);
        }
        System.out.println("Размер коллекции " + integerList.size());

        /**
         * (2) Перемещение курсора в начало коллекции перед 1-ым элементом
         */
        Iterator<Integer> iterator = integerList.iterator();

        /**
         * (3) Перебор элементов с первого до последнего
         */
        while (iterator.hasNext()) {

            /**
             * Перемещение курсора на следующий элемент и получение его значения
             */
            int i = iterator.next();

            System.out.println("Item " + i);
        }

        /**
         * (4) Сейчас курсор находится за последним элементом. Для установки в начало нужно создать новый итератор iterator2,
         * с предидущим итератором iterator проход по элементам коллекции уже не возможен
         * Через iterator2.next() перемещаем курсор на сдледующий элемент
         * Через iterator2.remove() удаляем элемент, на который указывает курсор
         */
        Iterator<Integer> iterator2 = integerList.iterator();
        while (iterator2.hasNext()) {
            int i = iterator2.next();
            iterator2.remove();
            System.out.println("Удален " + i);
        }
        System.out.println("Размер коллекции " + integerList.size());

    }
}
