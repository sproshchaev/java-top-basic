package com.prosoft;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс ClientChat использует сокеты по протоколу TCP для отправки текстового сообщениями серверу
 */
public class ClientChat {
    private Socket client = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private String msg = "";
    private int port = 8888;

    public static void main(String[] args) {
        ClientChat chat = new ClientChat();
        chat.setConnection();
    }

    /**
     * Метод setConnection()
     */
    void setConnection() {
        try {
            /**
             * Создание объекта клиентского сокета и подключение к серверу
             */
            client = new Socket("127.0.0.1", port);
            System.out.println("Connected to server");
            out = new ObjectOutputStream(client.getOutputStream());
            out.flush();
            in = new ObjectInputStream(client.getInputStream());
            do {
                /**
                 * Создание диалоговое окна для ввода текстового сообщения и это сообщение отправляется серверу
                 */
                msg = JOptionPane.showInputDialog(this, "Enter your message:");
                if (msg == null) {
                    msg = "";
                }
                sendMessage(msg);
                /**
                 * После отправки клиент автоматически переходит в режим ожидания ответа от сервера:
                 * клиент вызывает метод in.readObject(). Этот метод тоже блокирующий, поэтому клиент останавливает
                 * выполнение, ожидая ответ от сервера. И пщоэтому сделано так, чтобы сервер после каждого принятого
                 * сообщения отправлял клиенту уведомление о получении и тем самым выводил клиентское приложение из
                 * состояния блокировки
                 */
                if (!msg.equals("exit")) {
                    try {
                        msg = (String) in.readObject();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("server> " + msg);
                }
            } while (!msg.equals("exit"));
        } catch (IOException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void sendMessage(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
