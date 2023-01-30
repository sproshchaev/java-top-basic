package com.prosoft;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySemaphore implements Runnable {

    private Semaphore sem = new Semaphore(5);
    private int counter;

    public MySemaphore(int c) {
        this.counter = c;
    }

    @Override
    public void run() {
        try {
            sem.acquire();
            System.out.println(Thread.currentThread().getName() + " is working... " + this.counter);
            Thread.currentThread().sleep(counter);
            System.out.println(Thread.currentThread().getName() + " is finished!");
            sem.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(MySemaphore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
