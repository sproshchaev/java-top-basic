package com.prosoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Пример для JUnit4
 * import org.junit.Assert.*, org.junit.After, org.junit.Before, org.junit.Test
 */
public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setUp() {
        this.calc = new Calculator();
    }

    @After
    public void tearDown() {
        this.calc = null;
    }

    @Test
    public void testAdd_From_CalculatorTest() {
        double result = calc.add(8, 2);
        assertEquals(10, result, 1e-9);
    }

}
