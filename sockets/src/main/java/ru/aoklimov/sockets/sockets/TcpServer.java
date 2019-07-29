package ru.aoklimov.sockets.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer implements Runnable {


    @Override
    public void run() {
        try (ServerSocket ss = new ServerSocket(8053)) {
            Socket socket = ss.accept();
            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("Message from tcp server");
            writer.flush();
            System.out.println("Message from tcp server sended");
            System.out.println(sc.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
