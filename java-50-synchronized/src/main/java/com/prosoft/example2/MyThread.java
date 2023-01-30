package com.prosoft.example2;

/**
 * Потоковый класс
 */
public class MyThread extends Thread {

    /**
     * Поле типа MyResource инициализируется через конструктор
     */
    protected MyResource counter = null;

    public MyThread(MyResource counter) {
        this.counter = counter;
    }

    /**
     * В потоковом методе run() вызывается метод add()
     */
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            counter.add(i);
        }
    }
}
