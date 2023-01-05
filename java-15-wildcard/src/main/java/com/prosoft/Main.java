package com.prosoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * java-15-wildcard
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (5) Создание коллекций (списков) из Object, Animal, Pet,
         */
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());

        List<Pet> petList = new ArrayList<>();
        petList.add(new Pet());

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());

        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());

        /**
         * (6) Вызов метода showAnimals возможен с аргументами-списками из animalList, petList, catList, dogList
         */
        /* showAnimals(objectList); <- в метод showAnimals не может быть передан objectList, так как аргумент в нем
                                       (по коллекции) ограничен сверху <? extends Animal> */
        showAnimals(animalList);
        showAnimals(petList);
        showAnimals(catList);
        showAnimals(dogList);

        /**
         * (7) Вызов метода showPet возможен с аргументами-списками из objectList, animalList, petList
         */
        showPet(objectList);
        showPet(animalList);
        showPet(petList);
        /* showPet(catList); <- в метод showPet не может быть передан catList и dogList, так как аргумент в нем
           showPet(dogList);    (по коллекции) ограничен снизу <? super Pet> */

    }

    /**
     * Статический метод showAnimals() выводит в консоль списки, состоящие из экземпляров класса Animal
     * и любых его наследников
     * @param animalList
     */
    public static void showAnimals(Collection<? extends Animal> animalList) {
        for (Animal animal : animalList) {
            System.out.println("Animal: " + animal.toString());
        }
    }

    /**
     * Статический метод showPet() выводит в консоль списки, состоящие из экземпляров класса Pet и всех его суперклассов
     * (Animal, Object)
     * @param petList
     */
    public static void showPet(Collection<? super Pet> petList) {
        for (Object object : petList) {
            System.out.println("Object: " + object.toString());
        }
    }

}
