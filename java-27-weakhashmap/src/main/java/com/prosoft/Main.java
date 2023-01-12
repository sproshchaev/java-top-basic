package com.prosoft;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * java-27-weakhashmap
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекции WeakHashMap с ключами типа Car и значениями типа Integer
         */
        Map<Car, Integer> weakHashMap = new WeakHashMap<>();
        Car car1 = new Car(1, "Audi", "black");
        Car car2 = new Car(2, "BMW", "white");
        Car car3 = new Car(3, "Toyota", "blue");

        /**
         *  (2) Заполнение WeakHashMap элементами "ключ - значение"
         */
        weakHashMap.put(car1, 1000);
        weakHashMap.put(car2, 2000);
        weakHashMap.put(car3, 3000);

        /**
         * (3) Вывести все значения WeakHashMap с использованием цикла for-each
         */
        System.out.println("Before:");
        int count = 0;
        for (Object o : weakHashMap.entrySet()) {
            Map.Entry e = (Map.Entry) o;
            System.out.println(++count + ")" + e.getKey() + "->" + e.getValue());
        }
        System.out.println("");

        /**
         * (4) Удаление ключа car2
         */
        car2 = null;

        /**
         * (5) Создание и удаление 10000 массивов для вызова сборщика мусора в JVM (бессмысленные действия,
         * чтобы загрузить память и вызвать сборку мусора)
         */
        for (int i = 0; i < 10000; i++) {
            byte b[] = new byte[1000000];
            b = null;
        }

        /**
         * (6) Вывести все значения WeakHashMap с использованием цикла for-each
         */
        System.out.println("After:");
        count = 0;
        for (Object eo : weakHashMap.entrySet()) {
            Map.Entry e = (Map.Entry) eo;
            System.out.println(++count + ")" + e.getKey() + "->" + e.getValue());
        }
    }
}
