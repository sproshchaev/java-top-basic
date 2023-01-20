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
     *
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

        /**
         * Вычисление для потока минимального количества итераций, которые он должен выполнить
         */
        long limit = this.count / 2;

        System.out.println("*** The thread " + Thread.currentThread().getName() + " started with " + this.count);

        while (this.count >= 0) {
            System.out.println("From " + Thread.currentThread().getName() + " value =" + this.count);
            this.count -= 1;

            /**
             * На каждой итерации проверяем, выполнено ли уже это минимальное число итераций и не вызывался ли для потока
             * метод interrupt().
             * Вызов Thread.currentThread() позволяет получить доступ к объекту исполняемого потока.
             * Метод isInterrupted() - проверка флага внутри потока: если выставлен флаг внутри потока - метод вернет true,
             * метод не изменяет состояние флага
             *
             * Примечание: если в момент вызова метода interrupt() поток находится в активном состоянии, то в нем
             * выставляется соответствующий флаг, на который поток может отреагировать. Если же в момент вызова этого
             * метода поток находится в спящем или заблокированном состоянии, например, после вызова метода sleep() или
             * wait(), то он будет разбужен и выбросит исключение InterruptedException.
             * А выброшенное исключение снимет флаг, выставленный методом interrupt().
             */
            if (this.count <= limit && Thread.currentThread().isInterrupted()) {
                System.out.println("*** The thread is interrupted");
                return;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                /**
                 * Выброшенное исключение сбрасывает флаг прекращения работы, поэтому достаточно в catch блоке просто снова
                 * выставить его. Поток увидит флаг при продолжении выполнения и завершится так, как мы запланировали.
                 * Выставить этот флаг можно повторным вызовом метода interrupt() от имени объекта потока
                 */
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("*** The thread " + Thread.currentThread().getName() + " has finished");
    }
}
