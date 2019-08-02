package ru.aoklimov.sockets.simpleWebServer;

public class Main {
    public static void main(String[] args) {
        Thread sws = new Thread(new SimpleWebServer());
        sws.start();
    }
}
