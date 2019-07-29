package ru.aoklimov.sockets.sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer implements Runnable {
    @Override
    public void run() {
        try (DatagramSocket socket = new DatagramSocket(8154)) {
            DatagramPacket packet = new DatagramPacket(new byte[256], 256);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
