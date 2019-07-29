package ru.aoklimov.sockets.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient implements Runnable {
    @Override
    public void run() {
        try (Socket socket = new Socket("127.0.0.1", 8053)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            Scanner sc = new Scanner(socket.getInputStream());
            writer.println("Message from tcp client");
            writer.flush();
            System.out.println("Message from tcp client sended");
            System.out.println(sc.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
