package com.prosoft;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-53-executorservice
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Единственный поток, созданный методом newSingleThreadExecutor(), может выполнять много асинхронных задач
         * последовательно одну за другой
         *
         * При запуске приложения сначала возникнет пауза в 5 секунд, затем в консольное окно будет выведено сообщение
         * из первого потокового метода, а затем — из второго
         */

        /**
         * Создание объекта ExecutorService с именем executor. Метод newSingleThreadExecutor().
         * Это означает, что для нас был создан только один поток.
         */
        ExecutorService executor = Executors.newSingleThreadExecutor();

        /**
         * Дважды вызывается метод execute(), передавая ему в качестве параметра лямбда выражение, инициализирующее
         * объект Runnable.
         */
        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Hello from " + threadName);
        });
        executor.execute(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello again from " + threadName);
        });

        /**
         * Закрытие сервиса методом shutdown()
         */
        executor.shutdown();
        System.out.println("");

        /**
         * (2) newSingleThreadExecutor и submit()
         * Создание объект Runnable с помощью анонимного класса
         * Использование метода submit() для выполнения потоков, который принимает в качестве параметра объект Runnable
         * и асинхронно запускает его метод run() и возвращает объект типа Future.
         * В классе Future определен метод get(), позволяющий узнать статус завершения асинхронной задачи - если метод
         * вернет null, значит, асинхронная задача успешно завершилась
         */
        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        Future future = executor2.submit(new Runnable() {
            public void run() {
                String threadName = Thread.currentThread().
                        getName();
                System.out.println("This code is being executed " + "asynchronously in thread " + threadName);
            }
        });
        try {
            //returns null if the task completed successfuly
            if (future.get() == null)
                System.out.println("Success!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        executor2.shutdown();

        /**
         * (3) Если вам надо, чтобы какое-либо действие выполнялось в дополнительном потоке периодически, можете
         * использовать ScheduledExecutorService
         *
         * В этом случае мы используем для объекта executor тип ScheduledExecutorService. В этом типе определен метод
         * scheduleAtFixedRate(), позволяющий выполнять задачу с заданной периодичностью.
         * В первом параметре в этот метод передается задача в виде Runnable объекта, во втором — начальная задержка,
         * в третьем — период повторения, а в последнем — единица измерения временных интервалов. В данном коде
         * запускается задача task с нулевой начальной задержкой и с периодичностью две секунды. После запуска этой
         * задачи главный поток останавливается на пять секунд, а затем просыпается и останавливает выполнение периодичной
         * задачи вызовом метода cancel().
         *
         * Задача в дополнительном потоке успела выполниться три раза, а затем главный поток (после паузы в 5 секунд)
         * отменил ее.
         */
        ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };
        ScheduledFuture scheduledFuture = executor3.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        scheduledFuture.cancel(true);


        /**
         * (4) Пример "мягкого завершения"
         */
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            //wait 3 seconds for completion
            executor.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            //if service is not completed yet
            if (!executor.isTerminated()) {
                executor.shutdownNow();
                System.err.println("Make it to stop");
            }
            System.out.println("shutdown finished");
        }

    }
}
