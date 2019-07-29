package ru.aoklimov.sockets.sockets;

public class Main {
    public static void main(String[] args) {
        try {
            Thread tcpServer = new Thread(new TcpServer());
            tcpServer.start();
            Thread.sleep(5000);

            Thread tcpClient = new Thread(new TcpClient());
            tcpClient.start();
            Thread.sleep(5000);


            Thread udpServer = new Thread(new UdpServer());
            udpServer.start();
            Thread.sleep(5000);

            Thread udpClient = new Thread(new UdpClient());
            udpClient.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
