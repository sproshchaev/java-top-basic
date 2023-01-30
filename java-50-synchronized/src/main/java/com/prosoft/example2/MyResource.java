package com.prosoft.example2;

public class MyResource {
    private long counter = 0;

    /**
     * Синхронизированный метод add()
     * Для устранения проблемы рассинхронизации используется ключевое слово synchronized. Данный метод одновременно может
     * выполняться только одним потоком для конкретного объекта
     *
     * @param value
     */
    public synchronized void add(long value) {
        this.counter += value;
    }

    public long getCounter() {
        return counter;
    }
}
