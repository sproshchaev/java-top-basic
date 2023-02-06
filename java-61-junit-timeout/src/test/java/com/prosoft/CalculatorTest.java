package com.prosoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setUp() {
        this.calc = new Calculator(); // arrange: создание объекта
    }

    @After
    public void tearDown() {
        this.calc = null; // удаление объекта после теста
    }

    /**
     * Тестирование времени выполнения метода
     * Тест будет успешным при: @Test(timeout = 50)
     * Тест будет провален если для его выполнения требуется больше времени, чем 10 миллисекунд: @Test(timeout = 10)
     *
     * @throws InterruptedException
     */
    @Test(timeout = 50)
    public void testTimeOut() throws InterruptedException {
        for (long i = 1; i < 10; i++) {
            double result = calc.mult(i, i + 1);
            double expected = i * (i + 1);
            assertEquals(expected, result, 1e-9);
            Thread.sleep(2);
        }
    }

}
