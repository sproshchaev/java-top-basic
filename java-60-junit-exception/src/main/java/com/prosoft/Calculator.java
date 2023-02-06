package com.prosoft;

public class Calculator {

    /**
     * Если при делении двух вещественных чисел второй параметр метода будет 0, то исключение выброшено не будет -
     * результатом для вещественных чисел будет константа NaN (Not a Number)
     * В Java исключение выбрасывается только при целочисленном делении на 0!
     *
     * @param a
     * @param b
     * @return
     */
    public double div(double a, double b) {
        return a / b;
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
