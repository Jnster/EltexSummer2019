package ru.aoklimov.sockets.sockets;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient implements Runnable {
    @Override
    public void run() {
        try (DatagramSocket socket = new DatagramSocket(8153)) {
            byte[] data = "Message from udp client".getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(data, data.length, address,8154);
            socket.send(packet);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
