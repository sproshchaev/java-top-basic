package com.prosoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Calculator2Test {
    private Calculator2 calc;

    @Before
    public void setUp() {
        this.calc = new Calculator2();
    }

    @After
    public void tearDown() {
        this.calc = null;
    }

    @Test
    public void testAdd_From_Calculator2Test() {
        int result = calc.add(8, 2);
        assertEquals(10, result, 1e-9);
    }
}