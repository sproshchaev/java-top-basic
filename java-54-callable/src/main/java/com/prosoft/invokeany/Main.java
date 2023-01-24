package com.prosoft.invokeany;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * (Пример 2) Методы, позволяющих запускать потоки сервиса ExecutorService: invokeAny()
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 10; //number of threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(num);
        /**
         * Создание коллекции для хранения объектов типа Callable<String> и заполнили ее десятью объектами
         * нашего класса MyStringCallable. Коллекция нам нужна потому, что мы будем использовать метод invokeAny(),
         * который в качестве параметра принимает именно коллекцию объектов Callable и запускает какой-то один,
         * случайно выбранный из потоков. Управлять тем, какой именно поток будет активирован, мы не можем
         */
        //collection to keep created callables
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        Random r = new Random();
        //fill the collection in the loop
        for (int i = 0; i < num; i++) {
            MyStringCallable mc = new MyStringCallable(r.nextInt(1000));
            callables.add(mc);
        }
        String result = "";
        try {
            //launch a random thread out of 10
            result = executor.invokeAny(callables);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executor.shutdown();
        }
        //show the name of the launched thread
        System.out.println("Received from callable: " + result);
    }
}
