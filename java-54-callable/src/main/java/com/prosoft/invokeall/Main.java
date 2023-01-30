package com.prosoft.invokeall;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * (Пример 3) для активации потоков вызывается метод invokeAll(), который активирует все потоки и принимает их результаты в коллекцию
     * @param args
     */
    public static void main(String[] args) {

        int num = 10; //number of threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(num);
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            MyStringCallable mc = new MyStringCallable(r.nextInt(1000));
            callables.add(mc);
        }

        List<Future<String>> results = null;
        try {
            results = executor.invokeAll(callables);
            for (Future<String> result : results) {
                System.out.println("Received from callable: " + result.get());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (
                ExecutionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            executor.shutdown();
        }
    }

}
