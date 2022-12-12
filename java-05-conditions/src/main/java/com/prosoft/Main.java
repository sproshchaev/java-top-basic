package com.prosoft;

/**
 * java-05-conditions
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Слайд 39. Условный оператор if
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
        System.out.println("Цикл while:");
        int count = 0;
        while (count < 5) {
            System.out.println("count=" + count);
            count++;
        }

        /**
         * Слайд 43. Цикл do-while
         */
        System.out.println("Цикл do-while:");
        count = 0;
        do {
            System.out.println("count=" + count);
            count++;
        } while (count < 5);

        /**
         * Слайд 44. Цикл for
         */
        System.out.println("Цикл for:");
        for (int j = 0; j < 5; j++) {
            System.out.println("j=" + j);
        }

        /**
         * Слайд 45. Цикл for-each
         */
        System.out.println("Цикл for-each:");
        int [] nunbers = new int[] {0, 1, 2, 3, 4};
        for (int number : nunbers) {
            System.out.println("number=" + number);
        }

        /**
         * Слайд 46. Оператор break
         */
        System.out.println("Оператор break:");
        count = 0;
        while (count < 5) {
            count++;
            if (count > 2) {
                break; // прерывает выполнение цикла и передает управление в конец тела цикла
            }
            System.out.println("count=" + count);
        }

        /**
         * Слайд 47. Оператор continue
         */
        System.out.println("Оператор continue:");
        count = 0;
        while (count < 5) {
            count++;
            if (count == 3) {
                continue; // прерывает выполнения тела цикла и передает управление в начало цикла. Происходит пропуск текущей итерации цикла
            }
            System.out.println("count=" + count);
        }

    }
}
