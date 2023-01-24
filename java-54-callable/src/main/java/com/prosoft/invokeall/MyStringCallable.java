package com.prosoft.invokeall;

import java.util.concurrent.Callable;

public class MyStringCallable implements Callable<String> {
    private long wait;

    public MyStringCallable(int timeInMillis) {
        this.wait = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(wait);
        return Thread.currentThread().getName();
    }
}
