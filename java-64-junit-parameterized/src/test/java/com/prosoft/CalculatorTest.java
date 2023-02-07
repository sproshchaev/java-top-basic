package com.prosoft;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

/**
 * Параметризованные тесты
 * (1) Класс, который использует параметризованные тесты, должен предваряться аннотацией @RunWith с параметром Parameterized.class
 */
@RunWith(Parameterized.class)
public class CalculatorTest {

    /**
     * (2) В тестирующем классе обязательно должны быть параметры, представляющие набор данных для одного очередного
     * теста и должен быть определен конструктор с параметрами для этих полей
     */
    private double num1;
    private double num2;
    private double expectedResult;
    private static Calculator calculator;

    public CalculatorTest(double num1, double num2, double expectedResult) {
        this.num1 = num1;
        this.num2 = num2;
        this.expectedResult = expectedResult;
    }

    /**
     * (3) В тестирующем классе должен быть статический метод, возвращающий список наборов данных (значений полей)
     * для всех тестов. Список должен быть отмечен аннотацией @Parameters, в скобках аннотации указывается имя,
     * позволяющее идентифицировать тесты
     *
     * @return
     */
    @Parameterized.Parameters(name = "{index}:mult({0},{1})= {2}")
    public static Collection<Object[]> dataForTests() {
        return Arrays.asList(new Object[][]{{2, 3, 6}, {2, 7, 14}, {0, 3, 0}});
    }

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    /**
     * Метод testMult() выполняет тестирование метода mult() класса Calculator
     * Тест на умножение просто использует поля класса для задания исходных данных и результата умножения
     */
    @Test
    public void testMult() {
        double result = calculator.mult(num1, num2);
        assertEquals(expectedResult, result, 1e-9);
    }
}