package com.prosoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculatorTest {
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

    /**
     * Положительный сценарий работы метода div2()
     */
    @Test
    public void testDiv() throws DivByZeroException {
        double result = calc.div2(8, 2);
        assertEquals(4, result, 1e-9);

    }

    /**
     * Тест будет пройден только в том случае, если исключение возникнет
     * <p>
     * Junit4 - import static org.junit.Assert.*;
     *
     * @throws DivByZeroException
     */
    @Test(expected = DivByZeroException.class)
    public void testDivByZero() throws DivByZeroException {
        double result = calc.div2(8, 0);
    }

    /**
     * Метод testDivByZeroMessage() выполняет проверку вызова исключения и проверку самого сообщения
     *
     * Если исключение не выбрасывается тестируемым методом, то тест заваливается методом fail() с сообщением о том, что
     * должно быть исключение DivByZeroException.
     * Если же это исключение возникает, то оно отлавливается в первом блоке catch, и методом assertEquals()
     * выполняется сравнение сообщения, инкапсулированного в объекте-исключении, с текстом «Division by Zero». Тест
     * будет завален, если совпадения нет.
     * Если будет выброшено исключение другого класса, то это также приводит к неудаче теста с соответствующим выводом
     * о несовпадении полученного исключения с ожидаемым.
     */
    @Test
    public void testDivByZeroMessage() {
        try {
            double result = calc.div2(8, 0);
            fail("Division by Zero should have thrown a DivByZeroException");
        } catch (DivByZeroException e) {
            assertEquals("Division by Zero", e.getMessage());
        } catch (Exception e) {
            fail("Should be DivByZeroException, but have " + e.getClass());
        }
    }

}