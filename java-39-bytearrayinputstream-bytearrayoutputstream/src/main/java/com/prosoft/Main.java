package com.prosoft;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-39-bytearrayinputstream-bytearrayoutputstream
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (Пример 1) Чтение графического изображения из файла как массива байт и передача его в форму JFrame
         * для изображения на форме ImageFrame
         */
        File file = new File("java.jpg");
        try (
                /**
                 * Создание объекта байтового потока ByteArrayOutputStream, хранящего свои данные в оперативной памяти
                 */
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            /**
             * Чтение графического файла в объект BufferedImage с помощью класса ImageIO
             */
            BufferedImage bufferedImage = ImageIO.read(file);

            /**
             * Запись объект типа BufferedImage в поток
             */
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);

            /**
             * Преобразование потока в байтовый массив. Метод: toByteArray().
             */
            byte[] imageInByte = byteArrayOutputStream.toByteArray();

            /**
             * Класс, который принимает массив байт с изображением и выводит изображение во фрейме
             */
            ImageFrame imageFrame = new ImageFrame(imageInByte);

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * (Пример 2) Преобразование строки в байтовый поток и выполнение побайтового чтения потока
         * и одновременное преобразование прочитанных данных.
         * Поскольку при преобразовании мы создаем новую строку, здесь удобнее использовать класс StringBuilder
         */
        String line = "This is a sample string to be capitalized";
        try (
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(line.getBytes()) ) {
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = byteArrayInputStream.read()) != -1) {
                sb.append(Character.toUpperCase((char) ch));
            }
            System.out.println("Capitalized string: " + sb.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
