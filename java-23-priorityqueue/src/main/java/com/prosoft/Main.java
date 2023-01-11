package com.prosoft;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * java-23-priorityqueue
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание коллекции PriorityQueue из элементов Integer
         */
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();

        /**
         * (2) Добавление элементов. Методы add(), offer()
         */
        integerPriorityQueue.add(4);
        integerPriorityQueue.offer(3);
        integerPriorityQueue.offer(1);
        integerPriorityQueue.add(9);

        /**
         * (3) Вывод через метод toString не гарантирует вывод в отсортированном порядке: [1, 4, 3, 9]
         * The Iterator provided in method iterator() is not guaranteed to traverse the elements of the priority queue
         * in any particular order. If you need ordered traversal, consider using Arrays.sort(pq.toArray()).
         */
        System.out.println("PriorityQueue size=" + integerPriorityQueue.size() + ": " + integerPriorityQueue);

        /**
         * (4) Вывод элементов очереди через Iterator: 1, 4, 3, 9
         */
        System.out.print("Using an iterator: ");
        Iterator<Integer> iterator = integerPriorityQueue.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println("");

        /**
         * (5) Использование метода poll() позволяет получить элементы, находящиеся в очереди в сортированном порядке: 1, 3, 4, 9
         * Метод poll() удаляет элементы из очереди
         */
        System.out.print("Using the poll() method: ");
        int priorityQueueSize = integerPriorityQueue.size();
        for (int i = 0; i < priorityQueueSize; i++) {
            System.out.print(integerPriorityQueue.poll() + ", ");
        }
        System.out.println();

        /**
         * (6) Создание коллекции PriorityQueue из элементов Integer с использованием компаратора
         */
        IntComparator intComparator = new IntComparator();
        PriorityQueue<Integer> integerPriorityQueue2 = new PriorityQueue<>(intComparator);

        integerPriorityQueue2.add(4);
        integerPriorityQueue2.add(3);
        integerPriorityQueue2.add(5);
        integerPriorityQueue2.add(9);
        integerPriorityQueue2.offer(1);

        System.out.println("PriorityQueue2 size=" + integerPriorityQueue2.size() + ": " + integerPriorityQueue2);

        /**
         * (7) Вывод элементов очереди через Iterator: 1, 3, 5, 9, 4
         * Итератор не гарантирует проход по элементам в соответствии с компаратором
         */
        System.out.print("IntegerPriorityQueue2. Using an iterator: ");
        Iterator<Integer> iterator2 = integerPriorityQueue2.iterator();
        while(iterator2.hasNext()) {
            System.out.print(iterator2.next() + ", ");
        }
        System.out.println("");

        /**
         * (8) Извлечение элементов из очереди. Метод remove(): 1, 3, 4, 5, 9
         * Метод remove() извлекает элементы в соответствии с компаратором
         */
        System.out.print("Removing elements from the queue: ");
        while (!integerPriorityQueue2.isEmpty()) {
            System.out.print(integerPriorityQueue2.remove() + ", ");
        }
        System.out.println("");

    }
}
