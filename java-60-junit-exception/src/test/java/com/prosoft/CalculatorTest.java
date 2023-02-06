package com.prosoft;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest extends TestCase {
    private Calculator calc;

    /**
     * Метод с аннотацией @Before будет выполняться перед каждым тестом. Таким образом, для каждого теста будет создан
     * свой объект класса Calculator
     */
    @Before
    public void setUp() {
        this.calc = new Calculator(); // arrange: создание объекта
    }

    /**
     * Метод с аннотацией @After будет выполняться после каждого теста.
     * Метод очищает ссылку calc
     */
    @After
    public void tearDown() {
        this.calc = null; // удаление объекта после теста
    }

    @Test
    public void testDiv() throws DivByZeroException {
        double result = calc.div(8, 2);
        assertEquals(4, result, 1e-9);

    }

    /**
     * Для проверки выброса исключения необходимо использовать аннотацию @Test с параметром expected
     * Тест пройдет если исключение возникнет
     *
     * @throws DivByZeroException
     */
    @Test(expected = DivByZeroException.class)
    public void testDivByZero() throws DivByZeroException {
        double result = calc.div(8, 0);
    }

}