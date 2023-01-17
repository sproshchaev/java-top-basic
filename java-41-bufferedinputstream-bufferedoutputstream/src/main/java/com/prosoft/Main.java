package com.prosoft;

import java.io.*;

/**
 * java-41-bufferedinputstream-bufferedoutputstream
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Запись c использованием буферизации BufferedOutputStream
         *
         * Примечание: Используем try блок с ресурсами и уже известным вам приемом создаем буферизированную
         * обертку вокруг обычного потока FileOutputStream. Теперь запись в файл будет выполнена несколько быстрее, чем
         * при отсутствии буферизации. Кстати, имейте в виду, что массив buffer, используемый в коде, не имеет никакого
         * отношения к буферу потока. Это просто массив, из которого выполняется вставка данных в поток.
         * Буфер потока скрыт во внутренней реализации. Его размер равен 8192 байт, но это значение может изменяться
         * в зависимости от реализации. Разработчики JVM не советуют управлять этим размером
         */
        String text = "This lines of text should be written in file\r\n using buffered stream.\r\n"
                + "Just one more line.\r\n";
        try (FileOutputStream out = new FileOutputStream("test.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        /**
         * (2) Выполним чтение с использованием буферизации BufferedInputStream
         */
        try (FileInputStream fileInputStream = new FileInputStream(new File("test.txt"));
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            int c;
            while ((c = bufferedInputStream.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
