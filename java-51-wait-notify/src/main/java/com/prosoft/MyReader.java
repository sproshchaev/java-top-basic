package com.prosoft;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Первый поток MyReader выполняет чтение входного файл и записывающий нечетные строки в статическую строку line
 */
public class MyReader implements Runnable {
    /**
     * Объект locker в обоих потоках — это один и тот же объект!
     */
    private Object locker;

    private FileReader fileReader = null;

    public MyReader(String filePath, Object locker) {
        try {
            this.fileReader = new FileReader(filePath);
            this.locker = locker;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        int lineCounter = 0;
        String str = "";
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println("Reader:" + str);
                /**
                 * Задача - выбирать из входного файла строки с нечетными номерами и только их записывать в выходной файл «lines_out.txt»
                 */
                if ((lineCounter++) % 2 == 0) {
                    synchronized (locker) {
                        /**
                         * Записывается нечетная прочитанная строка в статическую переменную line
                         */
                        Main.line = str;
                        /**
                         * Когда эта работа будет завершена, первый поток вызовет метод notify(), разбудив тем самым второй
                         * поток, т.е. вызовом метода notify() выполняется активация потока писателя, после чего поток
                         * читателя засыпает
                         */
                        locker.notify();
                        /**
                         * Первый поток вызовет метод wait() и сам уснет, ожидая завершения второго потока
                         */
                        locker.wait();
                    }
                }
            }
            /**
             * Во втором synchronized выполняются те же действия, но в переменную line записывается слово «exit», по
             * которому будет завершено выполнение потока писателя. Читающий поток остановится, завершив чтение
             * входного файла
             */
            synchronized (locker) {
                Main.line = "exit";
                locker.notify();
                locker.wait();
            }
        } catch (IOException ex) {
            Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(MyReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
