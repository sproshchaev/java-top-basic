package com.prosoft.submit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-54-callable
 */
public class Main {
    /**
     * (Пример 1) Для активации потоков используется метод submit()
     *
     * @param args
     */
    public static void main(String[] args) {

        int num = 10; // число запускаемых потоков 1, 2, ..., 10

        /**
         * Создание объекта executor через фабричный метод newFixedThreadPool(num) класса Executors
         */
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(num);

        /**
         * Создание List<Future<Integer>> results, для сбора в нем возвращаемые результаты от всех потоков
         */
        List<Future<Integer>> results = new ArrayList<>();
        Random random = new Random();

        /**
         * Затем в цикле создали десять объектов Callable со случайными числовыми диапазонами и в этом
         * же цикле запустили все десять потоков вызовом метода submit(), сохраняя результат каждого потока в списке
         * results
         */
        for (int i = 0; i < num; i++) {
            int b = random.nextInt(10); // generate random interval
            int e = random.nextInt(100) + 10; //
            System.out.println("Limits:" + b + " to " + e);

            /**
             * Создавая объект MyCallable, мы задали интервал от ... до ..., планируя вычислить в потоке сумму чисел
             * из этого диапазона
             */
            MyCallable mc = new MyCallable(b, e);

            /**
             * Для запуска дополнительного потока применяется метод submit(), принимающий параметр типа Callable
             */
            Future<Integer> result = executor.submit(mc);
            results.add(result);
        }
        System.out.println("Results: ");
        try {
            /**
             * В цикле выводятся все результаты потоков.
             * Получить из класса Future возвращенный результат можно вызовом метода get(),
             * а вызовом метода isDone() можно узнать, завершился ли поток.
             * Данный пример схематичный. В реальном приложении надо было бы предпринять меры, позволяющие убедиться в том,
             * что все потоки завершились, прежде чем выводить результаты
             */
            for (Future<Integer> result : results) {
                System.out.println("Result is: " + result.get());
            }
            executor.shutdown();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

