package com.prosoft;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * (Пример 2) Если же мы не можем полагать, что размер данных во входном потоке приемлем, чтобы прочитать его за один
 * раз, то необходимо читать данные в цикле, блоками, помещая данные в массив, а затем из массива в файл.
 * Файл test.txt копируется в outputFile3.tmp
 */

public class FileBlockCopyTryWithResources {
    public void makeCopy() {
        /**
         * Размер массива для чтения выбирается произвольно и влияет только на число итераций, которые придется выполнить,
         * чтобы скопировать все данные из файла
         */
        byte[] buffer = new byte[8 * 1024];
        try (InputStream in = new FileInputStream(new File("test.txt"));
             OutputStream out = new FileOutputStream("outputFile3.tmp")) {
            /**
             * Переменная bytesRead, в которую метод read() возвращает количество прочитанных байт
             */
            int bytesRead = 0;

            /**
             * Выполняем чтение входного потока в цикле и на каждой итерации прочитанную порцию данных сразу записываем
             * в выходной поток. Это избавляет нас от необходимости создавать большой массив для чтения, чтобы в него
             * поместились все данные.
             * Во всех итерациях (если их будет больше одной) метод read() будет заполнять весь массив buffer
             * и значение bytesRead будет совпадать с размером массива buffer. А на последней итерации будет прочитана
             * оставшаяся порция данных, которая, как правило, будет меньше размера массива. Поэтому очень важно,
             * в методе write() в третьем параметре указывать именно количество фактически прочитанных байт, а не
             * размер массива
             */
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileBlockCopyTryWithResources.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileBlockCopyTryWithResources.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
