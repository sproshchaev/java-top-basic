package com.prosoft;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * java-23-priorityqueue
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекции PriorityQueue из строковых элементов
         */
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();

        /**
         * (2) Добавление элементов
         */
        integerPriorityQueue.add(4);
        integerPriorityQueue.offer(3);
        integerPriorityQueue.add(1);
        integerPriorityQueue.add(9);

        /**
         * (3) Вывод через метод toString не гарантирует вывод в отсортированном порядке
         * The Iterator provided in method iterator() is not guaranteed to traverse the elements of the priority queue
         * in any particular order. If you need ordered traversal, consider using Arrays.sort(pq.toArray()).
         */
        System.out.println("PriorityQueue size=" + integerPriorityQueue.size() + ": " + integerPriorityQueue);

        /**
         * (4) Вывод через
         */
        Iterator<Integer> iter = integerPriorityQueue.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        for (int i = 0; i < 4; i++) {
            Integer in = integerPriorityQueue.poll();
            System.out.println("Обрабатываем Integer:" + in);
        }

    }
}
