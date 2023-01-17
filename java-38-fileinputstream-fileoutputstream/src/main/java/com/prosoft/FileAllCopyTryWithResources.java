package com.prosoft;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * (Пример 1) Скопировать побайтово файл.
 * Примечание: Данные во входной поток попадают из файла на диске, считаем что размер этого файла позволяет
 * прочитать его сразу.
 * Выполняется чтение и запись файл побайтово, поэтому таким способом можем копировать не только текстовые файлы,
 * но и бинарные (и графические) файлы.
 * <p>
 * Для обработки исключений используется try-with-resources
 */
public class FileAllCopyTryWithResources {

    public void makeCopy() {

        /**
         * Использование try-with-resources позволяет убрать блок finally в котором закрывались ресурсы in и out,
         * данная конструкция все закроет автоматически
         */
        try (InputStream in = new FileInputStream(new File("test.txt"));
             OutputStream out = new FileOutputStream("outputFile2.tmp")) {
            byte[] buffer = null;
            buffer = new byte[in.available()];
            in.read(buffer);
            out.write(buffer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileAllCopyTryWithResources.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileAllCopyTryWithResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
