package com.prosoft;

/**
 * java-47-thread
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Создание экземпляра потокового класса
         */
        MyThread1 myThread1 = new MyThread1(10);

        try {
            /**
             * Запуск дополнительного потока. Метод start()
             */
            myThread1.start();

            /**
             * Блокировка основного потока main() до завершения дополнительного потока myThread1(). Метод join()
             * Еще вариант join(10000) - блокировка основного потока main() до завершения myThread1(), но блокировка
             * не более чем на 10 сек.
             */
            myThread1.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Работа основного потока завершена!");
    }
}

