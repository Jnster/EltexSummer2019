package ru.aoklimov.sockets.simpleWebServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer implements Runnable {

    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(4555)) {
            Socket socket = ss.accept();
            new Thread(new Sender(socket)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
