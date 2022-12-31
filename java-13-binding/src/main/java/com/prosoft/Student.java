package com.prosoft;

/**
 * Класс Student разширяет класс Person (который расширял Object)
 */
public class Student extends Person {

    /**
     * Переопределение метода toString()
     * @return
     */
    @Override
    public String toString() {
        return "Student";
    }
}
