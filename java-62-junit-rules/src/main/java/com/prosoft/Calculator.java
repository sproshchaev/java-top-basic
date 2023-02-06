package com.prosoft;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    /**
     * Метод div2() выбрасывает исключение при делении на 0
     *
     * @param a
     * @param b
     * @return
     * @throws DivByZeroException
     */
    public double div2(double a, double b) throws DivByZeroException {
        if (b == 0.0) {
            throw new DivByZeroException("Division by Zero");
        }
        return a / b;
    }
}
