package com.prosoft;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Класс SuiteTest выполняет запуск нескольких тестов с помощью аннотаций @Suite и @RunWith
 * Сам класс SuiteTest оставляется пустым — он необходим только как контейнер для запускаемых классов
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, Calculator2Test.class} )
public class SuiteTest {

}
