package com.prosoft.multiserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyListener implements Runnable {
    private Socket socket = null;
    private ObjectOutputStream output = null;
    private ObjectInputStream input = null;
    private String message = "";

    public MyListener(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client connected " + this.socket.getInetAddress().getHostName());
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
            do {
                try {
                    message = (String) input.readObject();
                    System.out.println("client> " + message);
                    if (message.equals("exit")) {
                        break;
                    }
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm: ss ");
                    Date date = new Date();
                    sendMessage("Message received " + dateFormat.format(date));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (!message.equals("exit"));
        } catch (IOException ex) {
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void sendMessage(String m) {
        try {
            output.writeObject(m);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
