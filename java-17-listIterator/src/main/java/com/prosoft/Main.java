package com.prosoft;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * java-17-listIterator
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создадим коллекцию строк и заполним ее элементы
         */
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            stringList.add("Item" + i);
        }

        /**
         * (2) Прямой проход от начала до конца коллекции
         */
        ListIterator<String> listIterator = stringList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(" -" + listIterator.next());
        }
        System.out.println("");

        /**
         * (3) Обратный проход с конца к началу элементов c использованием ранее созданного listIterator
         */
        while (listIterator.hasPrevious()) {
            System.out.println(" -" + listIterator.previous());
        }
        System.out.println("");

        /**
         * (4) Изменение элемента в итерации через метод set()
         */
        String item;
        while (listIterator.hasNext()) {
            item = listIterator.next();
            listIterator.set(item + ";");
        }
        for (String itemUpd : stringList) {
            System.out.println(" -" + itemUpd);
        }
        System.out.println("");

    }
}
