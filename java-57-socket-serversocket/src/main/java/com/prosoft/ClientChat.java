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
    private ObjectInputStream input = null;
    private ObjectOutputStream output = null;
    private String message = "";
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
            output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            input = new ObjectInputStream(client.getInputStream());
            do {
                /**
                 * Создание диалоговое окна для ввода текстового сообщения и это сообщение отправляется серверу
                 */
                message = JOptionPane.showInputDialog(this, "Enter your message:");
                if (message == null) {
                    message = "";
                }
                sendMessage(message);
                /**
                 * После отправки клиент автоматически переходит в режим ожидания ответа от сервера:
                 * клиент вызывает метод in.readObject(). Этот метод тоже блокирующий, поэтому клиент останавливает
                 * выполнение, ожидая ответ от сервера. И пщоэтому сделано так, чтобы сервер после каждого принятого
                 * сообщения отправлял клиенту уведомление о получении и тем самым выводил клиентское приложение из
                 * состояния блокировки
                 */
                if (!message.equals("exit")) {
                    try {
                        message = (String) input.readObject();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("server> " + message);
                }
            } while (!message.equals("exit"));
        } catch (IOException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
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
            output.writeObject(msg);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
