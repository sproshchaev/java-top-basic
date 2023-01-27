package com.prosoft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс CalculatorTest выполняет тестирование методов класса Calculator
 */
class CalculatorTest {

    /**
     * Метод addSuccess() выполняет успешное тестирование метода add()
     * Тело теста соответствует подходу AAA (arrange, act, assert)
     */
    @Test
    void addSuccess() {
        /**
         * arrange: создание объекта
         */
        Calculator calc = new Calculator();

        /**
         * act: выполнение метода
         * Для точности тестирования метода double add(double a, double b) используется преобразование к типу int
         */
        int result = (int) calc.add(8, 2);

        /**
         * assert: проверка
         */
        assertEquals(10, result);
    }

    @Test
    void sub() {

    }

    @Test
    void mult() {

    }

    @Test
    void div() {

    }
}