package ru.aoklimov.threads.runnable;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            Incrementer3000 a = new Incrementer3000(0, 15);
            Thread aT = new Thread(a);
            threads.add(aT);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
