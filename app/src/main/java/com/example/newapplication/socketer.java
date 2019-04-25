package com.example.newapplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

@SuppressWarnings("unused")
public class socketer {

    private Socket socket;

    public socketer() {
        System.out.println("Socket is opened");
    }

    public boolean openConnect()
    {
        try {
            socket = new Socket(InetAddress.getByName("73.111.129.247"), 6283);
        }
        catch(Exception e) {
            System.out.println("Error connecting to server");
            System.out.println(e);
        }
        try
        {
            System.out.println("\r\nConnected to Server: " + socket.getInetAddress());
        }
        catch(Exception e)
        {
            System.out.println("Error getting InetAddress");
        }

        return socket.isConnected();
    }

    public void sendMessage(String message) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
        out.flush();
    }

    public boolean closeSocket()
    {
        try {
            socket.close();
        }
        catch(Exception e)
        {

        }
        return true;
    }
}
