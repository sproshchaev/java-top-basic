package com.prosoft;

/**
 * Потоковый класс MyThread1 реализует интерфейс Runnable
 */
public class MyThread1 implements Runnable {
    /**
     * Поле count используется для передачи данных из вне в поток через конструктор
     */
    private long count;

    /**
     * Конструктор класса
     * @param count
     */
    MyThread1(long count) {
        this.count = count;
    }

    /**
     * Метод run() у класса Thread здесь переопределен и содержит код, который будет исполняться в дополнительном потоке
     */
    @Override
    public void run() {
        System.out.println("Начало работы дополнительного потока... ");

        for (long i = 0; i < count; i++) {
            System.out.print("A");
        }

        System.out.println("");
        System.out.println("Работа дополнительного потока завершена!");
    }
}
