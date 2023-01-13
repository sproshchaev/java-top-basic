package com.prosoft;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java-29-concurent-collection
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание concurrent коллекции CopyOnWriteArrayList
         */
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        /**
         * (2) Заполнение коллекции элементами. Метод add()
         */
        copyOnWriteArrayList.add("Belgium");
        copyOnWriteArrayList.add("USA");
        copyOnWriteArrayList.add("Poland");
        copyOnWriteArrayList.add("Brazil");
        copyOnWriteArrayList.add("Canada");

        /**
         * (3) Одновременное выполнение записи в коллекцию в одном потоке и чтение коллекции в другом потоке
         * Использование concurrent коллекции не вызывает исключительных ситуаций
         */
        Thread writerThread = new WriterThread("MyWriter", copyOnWriteArrayList);
        writerThread.start();

        Thread readerThread = new ReaderThread("MyReader", copyOnWriteArrayList);
        readerThread.start();

    }
}
