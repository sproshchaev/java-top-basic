package com.prosoft;

import java.util.Comparator;

/**
 * FishComparator
 */
public class FishComparator implements Comparator<Fish> {

    /**
     * (6.3) Переопределение метода compare
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Fish o1, Fish o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
