package com.prosoft;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-42-filereader-filewriter
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (1) Создание копии текстового файла. Если файл есть - он будет перезаписан.
         *
         * Примечание: Создаем два потока для чтения и записи. Связываем входной поток с существующим файлом «lines.txt», а выходному
         * потоку указываем имя файла lines1.txt, который должен быть создан. Оборачиваем входной поток потоком
         * BufferedReader для создания буферизации.
         * В цикле выполняется чтение - мы вызываем метод readLine() который за один вызов
         * считывает из файла текущую строку, возвращает ее в переменную line и перемещает указатель в файле на
         * следующую строку. Этот метод получен из потока BufferedReader.
         * Когда все строки файла будут прочитаны, readLine() занесет в line значение null и цикл остановится
         *
         * Файл test.txt должен быть заполнен текстовыми данными перед началом работы программы
         */
        try (FileReader fileReader = new FileReader("test.txt");
             FileWriter fileWriter = new FileWriter("test2.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int lineCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if ((lineCounter++) % 2 == 0) {
                    System.out.println(line);
                    fileWriter.write(line + System.getProperty("line.separator"));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * (2) Создание копии текстового файла. Если файл есть - в него будет добавлен текст.
         * Примечание - для добавления в файл второй параметр у экземпляра FileWriter должен быть true.
         *
         * Файл test.txt должен быть заполнен текстовыми данными перед началом работы программы
         */
        try (FileReader fileReader = new FileReader("test.txt");
             FileWriter fileWriter = new FileWriter("test3.txt", true)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int lineCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if ((lineCounter++) % 2 == 0) {
                    System.out.println(line);
                    fileWriter.write(line + System.getProperty("line.separator"));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
