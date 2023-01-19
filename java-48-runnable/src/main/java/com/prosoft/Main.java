package com.prosoft;

/**
 * java-48-runnable
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Создание экземпляра потокового класса - сначала создается объект класса производного от Runnable,
         * а затем — объект класса Thread, передав в конструктор объект наследника Runnable.
         */
        MyThread1 myThread1 = new MyThread1(10);
        Thread thread = new Thread(myThread1);

        try {
            /**
             * Запуск дополнительного потока. Метод start()
             */
            thread.start();

            /**
             * Блокировка основного потока main() до завершения дополнительного потока myThread1(). Метод join()
             * Еще вариант join(10000) - блокировка основного потока main() до завершения myThread1(), но блокировка
             * не более чем на 10 сек.
             */
            thread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Работа основного потока завершена!");

    }
}
