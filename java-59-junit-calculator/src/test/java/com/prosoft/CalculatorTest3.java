package com.prosoft;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Пример для JUnit4
 * import org.junit.Assert.assertEquals, org.junit.BeforeClass, org.junit.Test
 */
public class CalculatorTest3 {
    /**
     * Поле и метод с @BeforeClass должны быть статическими
     */
    private static Calculator calc;

    /**
     * Метод setUp() с аннотацией @BeforeClass будет выполняться один раз перед всеми тестами.
     * Объект calc будет создан один раз и использован во всех тестовых методах.
     * Метод с @BeforeClass должен быть статическим!
     */
    @BeforeClass
    public static void setUp() {
        calc = new Calculator(); // arrange: создание объекта
    }

    /**
     * Аналогично можно задать статический метод с аннотацией @AfterClass который будет выполняться после всех тестов
     */

    @Test
    public void testAdd() {
        double result = calc.add(8, 2); // act: выполнение метода
        assertEquals(10, result, 1e-9); // assert: проверка
    }

    @Test
    public void testSub() {
        double result = calc.sub(8, 2);
        assertEquals(6, result, 1e-9);
    }

    // остальные тесты класса...

}
