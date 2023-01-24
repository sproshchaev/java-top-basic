package com.prosoft;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySemaphore implements Runnable {

    Semaphore sem = new Semaphore(5); //5 is number
                                             //of free rooms
    int counter;

    public MySemaphore(int c) {
        this.counter = c; //just a random value to
                          //simulate a job
    }

    @Override
    public void run() {
        try {
            sem.acquire(); //decrease number of free
                           //rooms by 1
            System.out.println(Thread.currentThread().getName() + " is working... " + this.counter);
            Thread.currentThread().sleep(counter);
            System.out.println(Thread.currentThread().getName() + " is finished!");
            sem.release(); //increase number of free
                           //rooms by 1
        } catch (InterruptedException ex) {
            Logger.getLogger(MySemaphore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
