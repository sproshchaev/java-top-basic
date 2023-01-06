package com.prosoft;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * java-19-linkedlist
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание экземпляра класса LinkedList
         */
        LinkedList<String> linkedList = new LinkedList<>();

        /**
         * (2) Добавление в конец списка. Методы add(), addLast()
         */
        linkedList.add("three");
        linkedList.addLast("four");
        linkedList.add("six");
        linkedList.addLast("seven");
        linkedList.addLast("eight");
        linkedList.addLast("nine");
        linkedList.addLast("ten");
        System.out.println("LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (3) Добавление в начало списка. Метод addFirst()
         */
        linkedList.addFirst("two");
        linkedList.addFirst("one");
        System.out.println("LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (4) Добавление перед выбранным элементом. Метод add(index, value)
         * Поиск этого элемента ведется последовательным перебором либо от начала списка, либо от конца — в зависимости
         * от того, расположен index ближе к началу или к концу списка. Такая вставка выполняется медленнее, чем вставка
         * элементов в начало или конец списка. Чем больше коллекция - тем медленнее удаление!
         */
        linkedList.add(0, "zero");
        System.out.println("LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (5) Удаление элемента в начале и в конце. Методы removeFirst(), removeLast()
         * Удаление выполняется за постоянное время
         */
        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println("LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (6) Удалление элементов в произвольном месте списка по индексу. Метод remove(index)
         */
        linkedList.remove(1);
        System.out.println("LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (7) Удалление элементов в произвольном месте списка по значению. Метод remove(value)
         * Удаление в произвольном месте списка выполняется медленнее, чем в начале и конце списка.
         * При удалении по значению удаляется только первый найденный элемент
         */
        linkedList.remove("three");
        System.out.println("LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (8) Получение первого и последнего элемента. Методы peekFirst(), peekLast()
         */
        System.out.print("peekFirst()=" + linkedList.peekFirst() + ", peekLast()=" + linkedList.peekLast());
        System.out.println(" LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (9) Получение и удаление первого и последнего элемента. Методы pollFirst(), pollLast()
         */
        System.out.print("pollFirst()=" + linkedList.pollFirst() + ", pollLast()=" + linkedList.pollLast());
        System.out.println(" LinkedList: " + linkedList + ", size=" + linkedList.size());

        /**
         * (10) Перебор элементов коллекции через цикл for
         */
        System.out.print("for: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + ", ");
        }
        System.out.println("");

        /**
         * (11) Перебор элементов коллекции через цикл for-each
         */
        System.out.print("for-each: ");
        for (String item : linkedList) {
            System.out.print(item + ", ");
        }
        System.out.println("");

        /**
         * (12) Перебор элементов коллекции через цикл while
         */
        System.out.print("while: ");
        int i = 0;
        while (i < linkedList.size()) {
            System.out.print(linkedList.get(i) + ", ");
            i++;
        }
        System.out.println("");

        /**
         * (13) Перебор элементов коллекции через ListIterator в прямом направлении. Метод listIterator() указывает
         * на начало коллекции
         */
        System.out.print("ListIterator: ");
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }
        System.out.println("");

        /**
         * (14) Перебор элементов коллекции через ListIterator в обратом направлении
         */
        System.out.print("ListIterator: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ", ");
        }
        System.out.println("");

        /**
         * (15) Перебор элементов коллекции через Iterator в обратном направлении. Метод descendingIterator()
         * указывает на конец коллекции
         */
        System.out.print("descendingIterator: ");
        Iterator<String> listIterator2 = linkedList.descendingIterator();
        while (listIterator2.hasNext()) {
            System.out.print(listIterator2.next() + ", ");
        }
        System.out.println("");

        /**
         * (16) Добавление элементов при использовании Iterator. Метод add() необходимо вызывать после метода next()
         * (или previous() при обратном проходе коллекции)
         */
        System.out.print("ListIterator (add): ");
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.add("!");
        }
        System.out.println(linkedList + ", size=" + linkedList.size());

        /**
         * (17) Удаление элементов при использовании Iterator. Метод remove() необходимо вызывать после метода previous()
         * (или next() при прямом проходе коллекции)
         */
        System.out.print("ListIterator (remove): ");
        String item;
        while (listIterator.hasPrevious()) {
            item = listIterator.previous();
            if (item.equals("!")) {
                listIterator.remove();
            }
        }
        System.out.println(linkedList + ", size=" + linkedList.size());

        /**
         * (18) Изменение элементов при использовании Iterator. Метод set() необходимо вызывать после метода next()
         * (или previous() при обратном проходе коллекции)
         */
        System.out.print("ListIterator (set): ");
        while (listIterator.hasNext()) {
            item = listIterator.next();
            listIterator.set(item.concat("!"));
        }
        System.out.println(linkedList + ", size=" + linkedList.size());

    }
}
