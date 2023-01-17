package com.prosoft;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-36-file
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Имя файла (без пути)
         */
        String fileName = "test.txt";

        /**
         * (2) Имя каталога. Для получения пути к корневой папке проекта используется свойство user.dir
         */
        String dirName = System.getProperty("user.dir");

        /**
         * (3) Разделитель между именем папки и именем файла получаем из поля класса File.separator
         */
        String separator = File.separator;

        /**
         * (4) Полное имя файла: имя каталога плюс имя файла.
         */
        String fullName = dirName + separator + fileName;
        System.out.println("File path : " + fullName);

        /**
         * Создание объект класса File, указав в качестве пути корневую папку текущего проекта
         * Замечание: создание объекта класса File не приводит автоматически к созданию самого файла на диске!
         */
        File file = new File(fullName);

        /**
         * Класс File не имеет отношения к процессам чтения или записи, т.е. он не умеет читать или писать - для этих
         * целей применяются потоковые классы
         * Метод createNewFile() - создает файл на диске, но ничего не записывает в него
         */
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created!");
                } else {
                    System.out.println("Something Wrong!");
                }
            } catch (IOException ex) {
                Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File already exists!");
        }

        /**
         * Создание папок классом File. Методы:
         *   mkdir() - позволяет создать только одну папку
         *   mkdirs() - позволяет создать цепочку вложенных папок
         */
        String dirname = dirName + "/tmp/user/java/bin";
        File dir = new File(dirname);
        dir.mkdirs();



    }
}
