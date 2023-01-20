package com.prosoft;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Второй поток MyWriter пишет данные в выходной файл
 */
public class MyWriter implements Runnable {
    /**
     * Объект locker в обоих потоках — это один и тот же объект!
     */
    private Object locker;

    private FileWriter fileWriter = null;


    public MyWriter(String filePath, Object locker) {
        try {
            this.fileWriter = new FileWriter(filePath, true);
            this.locker = locker;
        } catch (IOException ex) {
            Logger.getLogger(MyWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        synchronized (locker) {
            while (Main.line != "exit") {
                try {
                    /**
                     * Поток MyWriter при выполнении первой итерации выполнит метод locker.wait(). Вызов этого метода
                     * приведет к тому, что поток MyWriter перейдет в режим ожидания, и ему не будет выделяться
                     * процессорное время, пока он не проснется.
                     * Поток MyWriter, вызвавший метод wait(), не может разбудить себя сам. Он активируется только в том
                     * случае, когда какой-либо другой поток вызовет метод notify() или notifyAll() на том же объекте
                     * блокировки, на котором был вызван метод wait().
                     */
                    locker.wait();
                    if (Main.line != "exit") {
                        fileWriter.write(Main.line + System.getProperty("line.separator"));
                    }
                    System.out.println("*** Written line:" + Main.line);
                    /**
                     * Завершив свою работу, второй поток вызовет метод notify(), чтобы разбудить первый поток,
                     * а сам перейдет к следующей итерации, в начале которой снова выполнит вызов метода wait() и уснет,
                     * ожидая, когда его разбудит первый поток
                     */
                    locker.notify();
                } catch (IOException ex) {
                    Logger.getLogger(MyWriter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyWriter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try {
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(MyWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
