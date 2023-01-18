package com.prosoft;

import java.io.*;

/**
 * java-44-systemin-systemout-systemerror
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Использование вывода в out при нормальном выполнении кода, и вывод в err — при возникновении исключений
         * Файл lines.txt должен быть создан перед началом работы в программе
         */
        try (InputStream input = new FileInputStream("lines.txt")) {
            System.out.println("File opened successfully!");
        } catch (IOException e) {
            System.err.println("File opening error:");
            e.printStackTrace();
        }

        /**
         * (2) Перенаправление потока out с использованием метода setOut() в файл
         * Метод println() будет направлять свой вывод в файл out.txt (вместо вывода в консоль)
         */
        try (FileOutputStream fileOutputStream = new FileOutputStream("out.txt");
             PrintStream printStream = new PrintStream(fileOutputStream)) {
            System.setOut(printStream);
            System.out.println("The output is redirected into file now!");
        } catch (Exception e) {
            System.err.println("File opening error:");
            e.printStackTrace();
        }
    }
}
