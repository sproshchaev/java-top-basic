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
    private ObjectOutputStream out = null;
    private ObjectInputStream in = null;
    private String msg = "";

    public MyListener(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client connected " + this.socket.getInetAddress().getHostName());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());
            do {
                try {
                    msg = (String) in.readObject();
                    System.out.println("client> " + msg);
                    if (msg.equals("exit")) {
                        break;
                    }
                    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm: ss ");
                    Date d = new Date();
                    sendMessage("Message received " + df.format(d));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (!msg.equals("exit"));
        } catch (IOException ex) {
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void sendMessage(String m) {
        try {
            out.writeObject(m);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
