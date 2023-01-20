package com.prosoft;

import java.util.Random;

/**
 * java-49-interrupt
 */
public class Main {
    public static void main(String[] args) {

        /**
         * 0..9
         */
        int value = (new Random()).nextInt(10);
        MyThread1 myThread1 = new MyThread1(value);
        Thread thread1 = new Thread(myThread1);

        value = (new Random()).nextInt(10);
        MyThread1 myThread2 = new MyThread1(value);
        Thread thread2 = new Thread(myThread2);
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();

        thread2.interrupt();;

        /**
         * Отправка доп. потоку уведомления о завершении работы. Метод interrupt()
         */
        thread1.interrupt();

        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Работа основного потока завершена!");

    }
}
