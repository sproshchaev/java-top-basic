package com.prosoft;

import java.util.HashMap;
import java.util.Map;

/**
 * java-24-hashmap
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекции с ключами типа String и значениями типа Integer
         */
        HashMap<String, Integer> phoneCodeHashMap = new HashMap<String, Integer>();

        /**
         * (2) Заполнение HashMap элементами "ключ - значение" (страна - телефонный код доступа). Метод put()
         */
        phoneCodeHashMap.put("Argentina", 54);
        phoneCodeHashMap.put("Norway", 47);
        phoneCodeHashMap.put("Canada", 1);
        phoneCodeHashMap.put("USA", 1);
        phoneCodeHashMap.put("Ukraine", 380);

        /**
         * (3) Вывести все значения HashMap
         */
        int count = 0;
        for (Map.Entry map : phoneCodeHashMap.entrySet()) {
            System.out.println(++count + ") " + map.getKey() + ": " + map.getValue());
        }
        System.out.println("");

        /**
         * (4) Получение значения по ключу. Для "Canada". Метод get()
         */
        System.out.println("Phone code for Canada: " + phoneCodeHashMap.get("Canada"));

        /**
         * (5) Изменить значение по ключу. Метод put()
         */
        phoneCodeHashMap.put("USA", 100);
        System.out.println("New Phone code for USA: " + phoneCodeHashMap.get("USA"));

        /**
         * (6) Удалить пару "ключ - значение"
         */
        phoneCodeHashMap.remove("USA");
        System.out.println("Phone code for USA: " + phoneCodeHashMap.get("USA"));
    }
}