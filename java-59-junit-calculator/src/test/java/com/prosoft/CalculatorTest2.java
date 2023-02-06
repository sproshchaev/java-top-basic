package com.prosoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Пример для JUnit4
 * import org.junit.Assert.*, org.junit.After, org.junit.Before, org.junit.Test
 */
public class CalculatorTest2 {
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
    public void testAdd() {
        double result = calc.add(8,2); // act: выполнение метода
        assertEquals(10, result,1e-9); // assert: проверка
    }
    @Test
    public void testSub() {
        double result = calc.sub(8,2);
        assertEquals(6, result,1e-9);
    }

    // Остальные тесты класса ...

}
