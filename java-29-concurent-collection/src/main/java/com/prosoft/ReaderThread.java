package com.prosoft;

import java.util.Iterator;
import java.util.List;

/**
 * Задача потока заключается собрать в строку info все элементы коллекции и вывести их в консольное окно.
 * Элементы в строке info отделяются один от другого пробелами. Смысл этой работы в том,
 * что, пока будет выполняться чтение коллекции (перебор ее элементов с помощью итератора), поток WriterThread будет
 * добавлять в нее новые элементы. И по мере выполнения приложения ReaderThread будет выводить в консоль изменяющуюся
 * коллекцию с новыми элементами
 */
public class ReaderThread extends Thread {

    private List<String> list;

    public ReaderThread(String name, List<String> list) {
        this.list = list;
        super.setName(name);
    }

    public void run() {
        while (true) {
            String info = super.getName() + ":";
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String el = iterator.next();
                info += " " + el;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println(info);
        }
    }

}
