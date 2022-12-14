package com.prosoft;

import java.util.SortedMap;
import java.util.StringTokenizer;

/**
 * java-08-string
 *
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Слайд 80. Строки String. Создание
         */
        String name = "Вася";
        String name2 = new String("Вася");
        System.out.println( "Строки: " + name + ", " + name2 );

        /**
         * Слайд 82. Статические методы класса String: valueOf
         */
        String value = String.valueOf(3);
        value = String.valueOf(0.5);
        value = String.valueOf(true);
        System.out.println("value=" + value);

        /**
         * Слайд 83. Статические методы класса String: format
         */
        String result = String.format("Hello, %s", "world!");
        System.out.println(result);

        /**
         * Слайд 85. Escape-последовательности
         */
        String result2 = "\"Hello, World\"";
        System.out.println("1) Экранирование кавычек: " + result2);

        /**
         * Слайд 88. Методы экземпляра класса: concat
         */
        String firstName = "Иван";
        String lastName = " Иванов";
        String fullName = firstName.concat(lastName);
        System.out.println("2) fullName=" + fullName);

        /**
         * Слайд 89. Методы экземпляра класса: length
         */
        System.out.println("3) fullName.length()=" + fullName.length());

        /**
         * Слайд 90. Методы экземпляра класса: isEmpty
         */
        System.out.println("4) fullName.isEmpty=" + fullName.isEmpty());

        /**
         * Слайд 91. Методы экземпляра класса: charAt
         */
        System.out.print("5) ");
        for (int i = 0; i < fullName.length(); i++) {
          System.out.print(fullName.charAt(i) + " ");
        }
        System.out.println("");

        /**
         * Слайд 92. Методы экземпляра класса: contains
         */
        System.out.println("6) fullName.contains(lastName)=" + fullName.contains(lastName));

        /**
         * Слайд 93. Методы экземпляра класса: startsWith
         */
        String str1 = "www.example.com";
        String str2 = "example";
        System.out.println("7) startsWith: " + str1.startsWith(str2, 4));

        /**
         * Слайд 93. Методы экземпляра класса: endsWith
         */
        String str3 = "Exercise";
        String str4 = "se";
        System.out.println("8) endsWith: " + str3.endsWith(str4));

        /**
         * Слайд 95. Методы экземпляра класса: trim
         */
        String str5 = "  www.example.com  ";
        System.out.println("9) trim: " + str5.trim() + "!");

        /**
         * Слайд 96. Методы экземпляра класса: toLowerCase
         */
        String str6 = "The Quick BroWn Fox!";
        System.out.println("10) toLowerCase: " + str6 + " -> " + str6.toLowerCase());

        /**
         * Слайд 97. Методы экземпляра класса: toUpperCase
         */
        String str7 = "The Quick BroWn Fox!";
        System.out.println("11) toUpperCase: " + str7 + " -> " + str7.toUpperCase());

        /**
         * Слайд 98. Методы экземпляра класса: indexOf
         */
        String str8 = "Test string";
        System.out.println("12) indexOf: " + str8 + ", 'n'=" + str8.indexOf('n', 0));

        /**
         * Слайд 99. Методы экземпляра класса: lastIndexOf
         */
        String str9 = "/home/user/index.html";
        int sep = str9.lastIndexOf('/');
        int dot = str9.lastIndexOf('.');
        System.out.println("13) lastIndexOf: " + str9 + ", sep=" + sep + ", dot=" + dot);

        /**
         * Слайд 100. Методы экземпляра класса: substring
         */
        String str10 = "www.example.com";
        System.out.println("14) substring: " + str10 + " " + str10.substring(4, 10));

        /**
         * Слайд 101. Методы экземпляра класса: replace
         */
        String str11 = "dog";
        System.out.println("15) replace: " + str11 + " -> " + str11.replace("d", "f"));

        /**
         * Слайд 102. Методы экземпляра класса: getBytes
         */
        String str12 = "ABCDEFGH";
        byte[] byteArray = str12.getBytes();
        System.out.println("16) getBytes: " + str12 + " -> " + byteArray[0]);

        /**
         * Слайд 103. Методы экземпляра класса: split
         */
        String str13 = "John Gilbert,43,UK";
        String[] strArray = str13.split(",");
        System.out.println("17) split: " + str13 + " -> ");
        for (String item : strArray) {
            System.out.println(" -" + item);
        }

        /**
         * Слайд 108. Строки String. Методы класса StringBuffer: append
         */
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" World!");
        System.out.println("18) sb=" + "\"" + sb + "\"");

        /**
         * Слайд 109. Строки String. Методы класса StringBuffer: insert
         */
        StringBuffer sb2 = new StringBuffer("I Java!");
        sb2.insert(2, "love ");
        System.out.println("19) sb2=" + "\"" + sb2.toString() + "\"");

        /**
         * Слайд 110. Строки String. Методы класса StringBuffer: insert
         */
        StringBuffer sb3 = new StringBuffer("Hello World!");
        sb3.reverse();
        System.out.println("20) sb3=" + "\"" + sb3.toString() + "\"");

        /**
         * Слайд 111. Строки String. Методы класса StringBuffer: delete
         */
        StringBuffer sb4 = new StringBuffer("Hello World!");
        System.out.println("21) sb4=" + sb4 + " -> " + sb4.delete(5, 11));

        /**
         * Слайд 112. Строки String. Методы класса StringBuffer: deleteCharAt
         */
        StringBuffer sb5 = new StringBuffer("Hello World!");
        System.out.println("22) sb5=" + sb5 + " -> " + sb5.deleteCharAt(11));

        /**
         * Слайд 113. Строки String. Методы класса StringBuffer: replace
         */
        StringBuffer sb6 = new StringBuffer("Hello World!");
        System.out.println("23) sb6=" + sb6 + " -> " + sb6.replace(6,11, "Friends"));

        /**
         * Слайд 117. Строки String.Класс StringTokenizer
         */
        String s = "Best,Java,programming,language.";
        System.out.println("24) s=" + s);
        StringTokenizer st = new StringTokenizer(s, ",");
        while (st.hasMoreTokens()) {
            System.out.println(" -" + st.nextToken());
        }
    }

}
