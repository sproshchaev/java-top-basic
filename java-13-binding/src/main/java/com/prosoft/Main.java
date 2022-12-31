package com.prosoft;

/**
 * java-13-binding
 *
 */
public class Main {
    /**
     * Метод main() вызывает метод newObject() и передает в качестве аргумента экземпляры классов Object, Person,
     * Student, Engineer
     * @param args
     */
    public static void main(String[] args) {
        newObject(new Object());
        newObject(new Person());
        newObject(new Student());
        newObject(new Engineer());
    }


    /**
     * Метод newObject() вызывает метод toString() у передаваемого в аргументах объекта
     * @param object
     */
    public static void newObject(Object object) {
        System.out.println(object.toString());
    }

}
