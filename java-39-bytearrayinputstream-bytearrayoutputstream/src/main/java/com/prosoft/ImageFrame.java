package com.prosoft;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Класс, который принимает массив байт с изображением и выводит изображение во фрейме
 */
public class ImageFrame {
    BufferedImage image = null;
    JFrame form = null;

    /**
     * В конструкторе класса мы создаем входной поток ByteArrayInputStream вокруг массива байт, который перед этим был
     * получен из выходного потока ByteArrayOutputStream
     *
     * @param imageInByte
     * @throws IOException
     */
    public ImageFrame(byte[] imageInByte) throws IOException {

        image = ImageIO.read(new ByteArrayInputStream(imageInByte));
        form = new JFrame();
        form.setSize(image.getWidth(), image.getHeight());
        form.setAlwaysOnTop(true);
        JPanel jPanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            }
        };

        jPanel.setSize(image.getWidth(), image.getHeight());
        form.add(jPanel);
        form.setVisible(true);
    }
}

