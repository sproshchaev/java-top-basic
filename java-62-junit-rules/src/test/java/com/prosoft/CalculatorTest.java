package com.prosoft;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calc;

    @Before
    public void setUp() {
        this.calc = new Calculator(); // arrange: создание объекта
    }

    @After
    public void tearDown() {
        this.calc = null; // удаление объекта после теста
    }

    /**
     * (1) Правила (Rules): The TemporaryFolder Rule
     */
    @Rule
    public final TemporaryFolder folder = new TemporaryFolder();

    /**
     * Методе testTempFile() во временный файл записывается таблица умножения на 3, полученная с помощью объекта класса
     * Calculator.
     * Затем эти числа прочитываются из файла, и происходит их сравнение с правильными значениями методом assertEquals().
     *
     * @throws IOException
     */
    @Test
    public void testTempFile() throws IOException {
        double result;
        File tempFile = folder.newFile();                           // задание файла во временной папке
        FileWriter writer = new FileWriter(tempFile);               // поток записи в файл
        for (int i = 2; i < 10; i++) {
            result = calc.mult(3, i);                            // вычисление произведения на 3
            String str = result + " ";
            writer.write(str);                                      // запись в файл
        }
        writer.close();                                             // закрыть файл записи
        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        String str = reader.readLine();                             // чтение всех данных
        reader.close();
        String[] numbers = str.split(" ");                    // разделение на строки-числа
        for (int i = 0; i < 8; i++) {
            result = Double.parseDouble(numbers[i]);                // преобразование в число
            assertEquals(3 * (i + 2), result, 1e-9);  // проверка
        }
    }

    /**
     * (2) Правила (Rules): ExpectedException Rule
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none(); // пустое исключение

    /**
     * Метод testDivByZero2() проверяет:
     * 1) возникновение исключения DivByZeroException.class
     * 2) проверяется, что исключение DivByZeroException.class содержит сообщение "Division by Zero"
     * <p>
     * Настройки исключения сбрасываются перед каждым тестом. Таким образом, для другого теста либо не ожидается
     * исключение (пустое исключение согласно правилу), либо требуется настройка ожидаемого класса исключения
     *
     * @throws DivByZeroException
     */
    @Test
    public void testDivByZero2() throws DivByZeroException {
        exception.expect(DivByZeroException.class);           // настройка ожидаемого класса исключения
        exception.expectMessage("Division by Zero");  // настройка ожидаемого сообщения в исключении
        double result = calc.div2(8, 0);                // здесь появляется исключение
    }

    /**
     * (3) The TimeOut Rule - проверки времени выполнения теста. Позволяет задать общий лимит времени сразу для
     * всех тестов
     */
    @Rule
    public final Timeout globalTimeOut = Timeout.millis(200);

    @Test
    public void testTimeOut() throws InterruptedException {
        for (long i = 1; i < 10; i++) {
            double result = calc.mult(i, i + 1);
            double expected = i * (i + 1);
            assertEquals(expected, result, 1e-9);
            Thread.sleep(2);
        }
    }

}