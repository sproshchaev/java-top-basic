package com.prosoft;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * java-25-linkedhashmap
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекции LinkedHashMap с ключами типа FishCollision и значениями типа Integer
         */
        Map<FishCollision, Integer> linkedHashMap = new LinkedHashMap<>();

        /**
         * (2) Заполнение LinkedHashMap элементами "ключ - значение"
         */
        FishCollision f1 = new FishCollision("eel", 1.1, 1);
        FishCollision f2 = new FishCollision("salmon", 2.2, 2);
        FishCollision f3 = new FishCollision("salmon", 3.3, 3);
        FishCollision f4 = new FishCollision("salmon", 4.4, 4);
        FishCollision f5 = new FishCollision("salmon", 4.4, 4);
        linkedHashMap.put(f1, 1);
        linkedHashMap.put(f2, 2);
        linkedHashMap.put(f3, 3);
        linkedHashMap.put(f4, 4);
        linkedHashMap.put(f5, 5);

        /**
         * (3) Вывести все значения HashMap
         * Поскольку у объектов f4 и f5 хеш коды одинаковые и метод equals() сообщил, что оба объекта тоже одинаковые,
         * произошло замещение. Объект f5 заменил в коллекции объект f4
         */
        int count = 0;
        for (Map.Entry<FishCollision, Integer> entry : linkedHashMap.entrySet()) {
            FishCollision key = entry.getKey();
            int b = entry.getValue();
            System.out.println(++count + ") " + key + " -> " + b);
        }
        System.out.println("");

        /**
         * (4) Вывести все значения по ключам f2, f3, f4, f5
         * Поскольку у объектов f4 и f5 хеш коды одинаковые и метод equals() сообщил, что оба объекта тоже одинаковые,
         * произошло замещение. Объект f5 заменил в коллекции объект f4
         */
        System.out.println("f2 = " + linkedHashMap.get(f2));
        System.out.println("f3 = " + linkedHashMap.get(f3));
        System.out.println("f4 = " + linkedHashMap.get(f4));
        System.out.println("f5 = " + linkedHashMap.get(f5));

    }
}
