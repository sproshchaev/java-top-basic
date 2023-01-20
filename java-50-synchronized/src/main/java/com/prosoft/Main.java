package com.prosoft;

import com.prosoft.example1.DecThread;
import com.prosoft.example1.IncThread;
import com.prosoft.example2.MyResource;
import com.prosoft.example2.MyThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-50-synchronized
 */
public class Main {

    /**
     * Объект ссылочного типа обеспечивает синхронизацию потоков приложения.
     * <p>
     * Примечание: тип этого поля Object, т.е. ссылочный (обязательное условие, но необязательно использовать именно
     * Object, можно String или Fish и т.п.), значение объекта также неважно
     */
    public static Object locker = new Object();

    public static int counter = 0;

    public static void main(String[] args) {

        /**
         * Example 1: создать два потока, один - увеличивает значение счетчика, второй - уменьшает его значение.
         * Синхронизировать доступ к счетчику со стороны потоков с использованием блока synchronized
         */
        int limit = 1000;
        IncThread incThread = new IncThread(limit);
        DecThread decThread = new DecThread(limit);
        incThread.start();
        decThread.start();
        try {
            incThread.join();
            decThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("counter=" + counter);

        /**
         * Example 2: создать два потока, обращающихся к одному методу add(), увеличивающему на единицу значение.
         * Синхронизировать метод add() для работы с потоками с использованием synchronized
         */
        MyResource counter = new MyResource();
        Thread thread1 = new MyThread(counter);
        Thread thread2 = new MyThread(counter);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("counter=" + counter.getCounter());

    }
}

