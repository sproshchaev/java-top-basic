package com.prosoft;

import java.util.Comparator;

/**
 * Класс IntComparator содержит переопределенный метод compare()
 */
public class IntComparator implements Comparator<Integer> {

    /**
     * Переопределение метода compare() для сортировки в порядке убывания элементов
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        return (o2 - o1);
    }
}

