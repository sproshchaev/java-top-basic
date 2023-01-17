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
 * Для обработки исключений используется try-catch-finally
 */
public class FileAllCopyTryCatchFinally {

    public void makeCopy() {
        /**
         * (1.1) Создаем объект in типа InputStream
         */
        InputStream in = null;
        OutputStream out = null;

        /**
         * (1.2) Создаем массив, в который будем читать содержимое потока.
         * Поток InputStream читает данные побайтово, поэтому тип массива — byte[].
         */
        byte[] buffer = null;

        /**
         * Использование try-catch-finally
         */
        try {
            /**
             * (1.3) Связываем объект in типа InputStream с существующим файлом на диске.
             * Этот файл уже должен находиться в текущей папке вашего приложения.
             * Конструктору потока мы передаем объект типа File
             */
            in = new FileInputStream(new File("test.txt"));

            /**
             * (1.4) Так как размер потока допускает чтение за один раз, то делаем размер массива таким, чтобы все
             * данные в нем разместились. Указываем размерность массива при создании — используя потоковый метод available().
             */
            buffer = new byte[in.available()];

            /**
             * (1.5) Метод read() за один вызов читает все данные из потока в созданный байтовый массив
             */
            in.read(buffer);

            /**
             * (1.6) Для создания копии прочитанного файла создаем выходной поток out типа OutputStream.
             * Используя класс File, ассоциируем выходной поток с файлом на жестком диске.
             * Для выходного потока можно указать не существующий файл, и поток создаст этот файл автоматически
             */
            File file = new File("outputFile.tmp");
            out = new FileOutputStream(file);

            /**
             * (1.7) За один вызов метода write() от объекта выходного потока, записываем содержимое нашего массива в файл
             */
            out.write(buffer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileAllCopyTryCatchFinally.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileAllCopyTryCatchFinally.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /**
             * Закрытие входного и выходного потоков в блоке finally, который должен выполнится в любом случае
             */
            try {
                in.close();
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(FileAllCopyTryCatchFinally.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * (2) Если же мы не можем полагать, что размер данных во входном потоке приемлем, чтобы прочитать его за один
         * раз, то надо использовать следующий подход
         */

    }

}
