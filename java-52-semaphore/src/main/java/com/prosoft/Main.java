package com.prosoft;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-52-semaphore
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание 20 потоков класса MySemaphore запуск их друг за другом
         * Примечание: друг за другом запустились первые пять потоков. Затем добавление потоков приостановилось, потому
         * что семафор не позволяет большему количеству потоков получить доступ к потоковому методу. И только когда один
         * из пяти потоков завершил работу в методе run(), его место занял следующий из ожидающих
         */
        Random random = new Random();
        MySemaphore ms = new MySemaphore(random.nextInt(2000) + 1000);
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(ms);
            thread.start();
        }

        /**
         * (2) Решение этой же задачи с использованием анонимного класса (без создания отдельного класса MySemaphore)
         */
        System.out.println("Вариант 2:");
        Runnable task = new Runnable() {
            Semaphore sem = new Semaphore(5);
            Random r = new Random();
            int counter = r.nextInt(2000) + 500;

            @Override
            public void run() {
                try {
                    sem.acquire();
                    System.out.println(Thread.currentThread().getName() + " is working... " + this.counter);
                    Thread.currentThread().sleep(counter);
                    System.out.println(Thread.currentThread().getName() + " is finished!");
                    sem.release();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MySemaphore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            new Thread(task).start();
        }
    }
}
