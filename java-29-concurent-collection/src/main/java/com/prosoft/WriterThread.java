package com.prosoft;

import java.util.List;

/**
 * Поток, выполняющий запись
 * Поток работает постоянно, записывая в коллекцию новые элементы. Новые элементы создаются в строке
 * new_item как конкатенация слова «element» и постоянно увеличивающегося целого значения.
 * После добавления каждого элемента в консоль выводится сообщение «New element added!». Для имитации выполнения сложной
 * работы поток приостанавливается на одну секунду при записи каждого нового элемента
 */
public class WriterThread extends Thread {
    private List<String> list;
    private int item;

    public WriterThread(String name, List<String> list) {
        this.list = list;
        item = 0;
        super.setName(name);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            String new_item = "element" + item++;
            list.add((String) (new_item));
            System.out.println(super.getName() + "New element added!");
        }

    }
}
