package com.prosoft.multiserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiServer {
    private ServerSocket listener = null;
    private Socket client = null;
    private int maxCount = 10; //max number of clients
    private int count = 0; //current client number
    private int port = 8888;

    public static void main(String[] args) {
        System.out.println("MultiServer start...");
        MultiServer chat = new MultiServer();
        chat.createConnection();
    }

    void createConnection() {
        try {
            listener = new ServerSocket(port, maxCount);
            while (count <= maxCount) {
                count++;
                client = listener.accept();
                MyListener ml = new MyListener(client);
                Thread t = new Thread(ml);
                t.setDaemon(true);
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(MultiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
