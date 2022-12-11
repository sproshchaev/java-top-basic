package com.prosoft;

/**
 * java-05-conditions
 */
public class Main {

    public static void main(String[] args) {

        /**
         * слайд 39. Условный оператор if
         */
        int i = 100;
        if (i <= 100) {
            System.out.println("Конструкция if: (if) i=" + i);
        }

        i = 101;
        if (i <= 100) {
            System.out.println("Конструкция if-else: (if) i=" + i);
        } else {
            System.out.println("Конструкция if-else: (else) i=" + i);
        }

        /**
         * Слайд 40. Оператор Switch
         *
         */
        int month = 1; // должен быть: byte (Byte), short (Short), char (Character), int (Integer), String
        String monthString;
        switch (month) {
            case 1:
                monthString = "January";
                break; // (не обязательный) если встречается конструкция break — то управление передается за пределы команды switch.
                       // Если его нет – код продолжит выполнение (игнорируя дальнейшие сравнения значений в блоках case)
                       // до первого встреченного break или до конца оператора switch
            case 2:
                monthString = "February";
                break;
            default: // (не обязательный) если не выбрано ни одно условие case - переход в default
                monthString = "Some month";
                break;
        }
        System.out.println("Month " + month + " is " + monthString);

        /**
         * Слайд 42. Цикл while
         */


    }
}
