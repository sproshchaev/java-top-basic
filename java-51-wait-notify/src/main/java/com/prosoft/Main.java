package com.prosoft;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-51-wait-notify
 */
public class Main {

    /**
     * Строка, через которую происходит чтение и запись файлов — открытое статическое поле класса
     */
    public static String line = "";

    /**
     * Задача: Из произвольного текстового файла считывать строки с нечетными номерами и записывать в другой файл.
     * Работу по чтению и записи надо выполнять в разных дополнительных потоках.
     * <p>
     * Проект решения: Первый поток MyReader читает файл, выбирает требуемую строку и заносит эту строку в String
     * переменную line.
     * Второй поток MyWriter записывает эту переменную line в выходной файл.
     * Надо сделать так, чтобы первый поток MyReader, занеся прочитанную строку в переменную line, сообщал второму
     * потоку MyWriter о том, что тот может выполнять запись. А второй поток MyWriter, выполнив запись, должен сообщать
     * первому MyReader, что переменную line уже можно затирать и заносить туда значение следующей строки.
     * Таким образом оба потока должны работать, пока не выберут и не запишут в выходной файл все требуемые строки
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Объект locker в обоих потоках — это один и тот же объект!
         * Объект синхронизации не открытый и статический, а передается каждому потоку в конструктор
         */
        Object locker = new Object();

        /**
         * Входным файлом является текстовый документ с именем «lines.txt»
         */
        MyReader reader = new MyReader("lines.txt", locker);
        MyWriter writer = new MyWriter("lines_out.txt", locker);
        Thread thread1 = new Thread(reader);
        Thread thread2 = new Thread(writer);
        thread1.setDaemon(true);
        thread2.setDaemon(true);
        thread2.start();
        try {
            /**
             * Возможна ситуация, при которой первый поток запишет строку из файла в переменную line до того, как второй
             * поток будет находиться в режиме ожидания. При этом первый поток вызовом метода notify() никого не разбудит.
             * Второй же поток, вызвав с опозданием метод wait(), не дождется, когда первый поток его разбудит — ведь
             * первый поток тоже уже будет спать после «холостого» вызова notify(). Чтобы этого не произошло, мы в методе
             * main() первым запустили именно второй поток и дали ему фору в 500 миллисекунд
             */
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        thread1.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
