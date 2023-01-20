package com.prosoft.example1;

import com.prosoft.Main;

public class DecThread extends Thread {
    int limit;

    public DecThread(int limit) {
        this.limit = limit;
    }

    public void run() {
        for (int i = 0; i < limit; i++) {
             /**
             * Synchronized блок - код, заключенный в данный блок одновременно сможет выполняться только одним потоком
             */
            synchronized (Main.locker) {
                Main.counter--;
            }
        }
    }
}
