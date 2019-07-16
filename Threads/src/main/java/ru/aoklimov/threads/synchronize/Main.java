package ru.aoklimov.threads.synchronize;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new LinkedList<>();
        BlockingPrinter printer = new BlockingPrinter();

        for (int i = 0; i < 15; i++) {
            Thread thread = new Thread(printer::inc);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
