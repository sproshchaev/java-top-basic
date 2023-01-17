package com.prosoft;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * (Пример 3) Выполнить чтение побайтово (без использования массива), что медленнее, но иногда бывает необходимо обрабатывать
 * каждый прочитанный байт
 * Файл test.txt копируется в outputFile4.tmp
 */
public class FileByteCopyTryWithResources {

    public void makeCopy() {

        /**
         * Выполнение чтение входного потока в цикле. Метод read(), который читает один байт и записывает в файл.
         */
        try (InputStream in = new FileInputStream(new File("test.txt"));
             OutputStream out = new FileOutputStream("outputFile4.tmp")) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileByteCopyTryWithResources.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileByteCopyTryWithResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
