package com.prosoft.submit;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int begin;
    private int end;

    public MyCallable(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    /**
     * Метод call() возвращает результат типа Integer, и базовый интерфейс Callable параметризирован этим типом.
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = this.begin; i <= this.end; i++) {
            sum += i;
        }
        return sum;
    }
}
