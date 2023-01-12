package com.prosoft;

import java.util.*;

/**
 * java-26-treemap
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекции TreeMap с ключами и значениями типа String
         */
        Map treeMap = new TreeMap<>();

        /**
         * (2) Заполнение элементами. Метод put()
         */
        treeMap.put("Brazil", "Brazilia");
        treeMap.put("Canada", "Ottawa");
        treeMap.put("Denmark", "Copenhagen");
        treeMap.put("France", "Paris");
        treeMap.put("Ukraine", "Kyiv");
        treeMap.put("Sweden", "Stockholm");
        treeMap.put("Austria", "Vein");

        /**
         * (3) Вывод всех элементов коллекции TreeMap
         * Элементы отсортированы по правилам сортировки для типа String (естественный порядок)
         */
        int count = 0;
        for (Object o : treeMap.entrySet()) {
            Map.Entry e = (Map.Entry) o;
            System.out.println(++count + ") " + e.getKey() + " " + e.getValue());
        }
        System.out.println("");

        /**
         * (4) Использование итератора для перебора элементов коллекции TreeMap
         */
        Iterator iter = treeMap.entrySet().iterator();
        count = 0;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(++count + ") " + key + " -> " + value);
        }
        System.out.println("");

        /**
         * (5) Получение из TreeMap отдельно коллекцию ключей. Метод keySet()
         */
        List keyList = new ArrayList(treeMap.keySet());
        System.out.println("keyList: " + keyList);

        /**
         * (6) Получение из TreeMap отдельно коллекцию значений. Метод values()
         */
        List valueList = new ArrayList(treeMap.values());
        System.out.println("valueList: " + valueList);
        System.out.println("");

        /**
         * (7) Создание коллекции TreeMap с ключом Car и значением Integer с использованием анонимного компаратора,
         * переопределенного в конструкторе (Car по возрастанию id)
         */
        Map<Car, Integer> treeMap2 = new TreeMap<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return (int) (o1.getId() - o2.getId());
            }
        });

        /**
         * (8) Заполнение коллекции элементами. Использование анонимного класса
         */
        treeMap2.put(new Car(1, "BMV", ""), 1000);
        treeMap2.put(new Car(20, "Toyota", ""), 2000);
        treeMap2.put(new Car(3, "Audi", ""), 3000);

        /**
         * (9) Вывод элементов коллекции по возрастанию id
         */
        System.out.println("Cars: ");
        count = 0;
        for (Object o : treeMap2.entrySet()) {
            Map.Entry e = (Map.Entry) o;
            System.out.println(++count + ") " + e.getKey() + " " + e.getValue());
        }
        System.out.println("");

    }
}
