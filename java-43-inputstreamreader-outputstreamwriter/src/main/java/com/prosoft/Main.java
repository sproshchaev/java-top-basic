package com.prosoft;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-43-inputstreamreader-outputstreamwriter
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Посимвольная запись из одного файла в другой с применением кодировки
         *
         * Примечание: Поток InputStreamReader создается как обертка вокруг байтового потока FileInputStream, но при создании
         * указывается в конструкторе InputStreamReader кодировка windows-1251, в которой создан файл lines.txt
         * Для английского языка в ANSI кодировке имя кодовой страницы будет windows-1252
         * Здесь производится чтение символов в ANSI из lines.txt и запись в кодировке UTF–8 в файл lines2.txt.
         * Чтение входного файла и запись в выходной производится по одному символу
         */
        try (FileInputStream fileInputStream = new FileInputStream(new File("lines.txt"));
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "windows-1251");
             FileOutputStream fileOutputStream = new FileOutputStream(new File("lines2.txt"));
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8")) {
            int c;
            while ((c = inputStreamReader.read()) != -1) {
                System.out.print((char) c);
                outputStreamWriter.write(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");

        /**
         * (2) Построчная запись одного файла в другой с применением кодировки (с буферизацией)
         *
         * Примечание: создание потока BufferedReader вокруг потока InputStreamReader для получения возможности
         * использования метода readLine().
         * Поток BufferedWriter создан вокруг потока OutputStreamWriter для возможности использования метода write(),
         * выполняющим запись строками
         */
        try (FileInputStream fileInputStream = new FileInputStream(new File("lines.txt"));
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "windows-1251");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileOutputStream fileOutputStream = new FileOutputStream(new File("lines2.txt"));
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line + System.getProperty("line.separator"));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
