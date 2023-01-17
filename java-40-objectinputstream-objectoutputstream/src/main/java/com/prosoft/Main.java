package com.prosoft;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-40-objectinputstream-objectoutputstream
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание объекта потока FileOutputStream и связывание его с файлом fish.txt, в который будет записываться
         * объект класса Fish.
         * Файл fish.txt бинарный и не доступен для чтения.
         */
        try (FileOutputStream fileOutputStream = new FileOutputStream("fish.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            Fish fish = new Fish("salmon", 2.5, 180);

            /**
             * Создаем объект потока ObjectOutputStream вокруг ранее созданного объекта потока FileOutputStream.
             * Т.е. поток ObjectOutputStream оборачивает поток FileOutputStream.
             * Теперь поток ObjectOutputStream тоже связан с файлом fish.txt, но уже обладает качествами, которые отсутствуют
             * у потока FileOutputStream. Когда выполняется обертка одного потока вокруг другого, то добавляется потоку
             * новые возможности - теперь можем записывать в поток объекты любых классов, потому, что у потока
             * появился метод writeObject(), которого не было у потока FileOutputStream
             */
            objectOutputStream.writeObject(fish);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * (2) Чтение файла fish.txt
         * Создаем поток ObjectInputStream как обертку вокруг потока FileInputStream и используем метод readObject()
         * для чтения объекта из файла. Метод readObject() возвращает тип Object, в связи с чем необходимо выполнять
         * явное преобразование типа к требуемому типу данных
         */
        try (FileInputStream fileInputStream = new FileInputStream(new File("fish.txt"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Fish fish = (Fish) objectInputStream.readObject();
            System.out.println(fish);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
