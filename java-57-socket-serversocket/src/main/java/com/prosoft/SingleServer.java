package com.prosoft;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс SingleServer использует сокеты по протоколу TCP для приема текстового сообщения от клиента
 * Однопоточный сервер - не может общаться с несколькими клиентами одновременно
 */
public class SingleServer {
    /**
     * Создание ссылки listener для серверного сокета
     */
    private ServerSocket listener = null;

    /**
     * Создание ссылки client для приема в нее сокеты подключающихся клиентов
     */
    private Socket client = null;
    /**
     * Создание входного и выходного потоков ввода–вывода, чтобы выполнять пересылку данных с использованием потоков
     */
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private int port = 8888;
    private String msg = "";

    /**
     * Метод main() содержит всю логику диалога между сервером и подключающимися клиентами выносим в метод listen()
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("SingleServer start...");
        SingleServer server = new SingleServer();
        while (true) {
            server.listen();
        }
    }

    /**
     * Метод listen()
     */
    void listen() {
        try {
            /**
             * Создание объекта серверного сокета
             */
            listener = new ServerSocket(port);
            System.out.println("Waiting for connection");

            /**
             * Вызов метода accept() приостанавливает выполнение приложения пока не подключится клиент.
             * При подключении клиента accept() возвращает сокет этого клиента, который назначается объекту client
             */
            //app is blocked by accept() call until
            //a client connection
            client = listener.accept();

            /**
             * C помощью объекта client мы создаем потоки ввода вывода между нашим приложением и подключившимся клиентом.
             * Для создания этих потоков мы используем методы client.getOutputStream() и client.getInputStream().
             */
            System.out.println("Client connected " + client.getInetAddress().getHostName());
            out = new ObjectOutputStream(client.getOutputStream());
            out.flush();
            in = new ObjectInputStream(client.getInputStream());

            /**
             * Цикл, в котором будет происходить диалог. Клиент будет присылать серверу текстовые сообщения.
             * Сервер будет выводить полученные сообщения в консольное окно, и после каждого полученного сообщения
             * отправлять клиенту ответ с уведомлением о получении сообщения и указанием точного момента времени
             * получения сообщения.
             * Диалог будет продолжаться до тех пор, пока клиент не пришлет сообщение «exit».
             */
            //start dialog
            do {
                try {
                    msg = (String) in.readObject();
                    //echoed received message
                    System.out.println("client> " + msg);
                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date d = new Date();
                    sendMessage("Message received;" + df.format(d));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SingleServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (!msg.equals("exit"));
        } catch (IOException ex) {
            Logger.getLogger(SingleServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (listener != null) {
                    listener.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SingleServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Метод sendMessage() производит отправку сообщения клиенту
     *
     * @param msg
     */
    void sendMessage(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(SingleServer.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
