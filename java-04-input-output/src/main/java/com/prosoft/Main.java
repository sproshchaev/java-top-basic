package com.prosoft;

import java.util.Scanner;

/**
 * java-04-input-output
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Слайд 29. Вывод в консоль (Output)
         */
        System.out.print("Вывод консоль без перевода строки Hello World!");

        System.out.println("Вывод консоль c переводом строки Hello World!");

        System.out.println("Вывод в новой строке:");

        int count = 500;
        boolean isReady = true;
        System.out.println("Преобразование типа int, boolean к строке не обязательно count=" + count + ", isReady=" + isReady);

        /**
         * Форматированный вывод через метод .printf:
         * Спецификаторы:
         * %a Шестнадцатеричное значение с плавающей точкой
         * %b Логическое (булево) значение аргумента
         * %c Символьное представление аргумента
         * %d Десятичное целое значение аргумента
         * %h Хэш-код аргумента
         * %e Экспоненциальное представление аргумента
         * %f Десятичное значение с плавающей точкой
         * %g Выбирает более короткое представление из двух: %е или %f
         * %o Восьмеричное целое значение аргумента
         * %n Вставка символа новой строки
         * %s Строковое представление аргумента
         * %t Время и дата
         * %x Шестнадцатеричное целое значение аргумента
         * %% Вставка знака %
         */
        System.out.printf("Форматированный вывод переменных: у %s есть: x = %d", "Саши", 5);
        System.out.println("");

        /**
         * Слайд 30. Ввод в консоль (Input)
         */
        Scanner scanner = new Scanner(System.in); // объявление и создание нового сканнера

        System.out.println("Использование nextLine(). Введите ваше имя: ");

        String name = scanner.nextLine();

        System.out.println("Использование nextInt(). Сколько вам лет: ");

        int age = scanner.nextInt();

        System.out.print("Использование nextFloat(). Введите результат 1,5 + 2,1=");

        float result = scanner.nextFloat();

        System.out.print("Использование next() считывает введённую строку до первого пробела. Введите несколько слов через пробел: ");

        String word = scanner.next();

        System.out.printf("Вы ввели: %s, %d, %f, %s", name, age, result, word);

        scanner.close(); // <- сканнер это ресурс, который должен открываться перед началом работы и закрываться после

    }
}
