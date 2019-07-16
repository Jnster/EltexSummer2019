package ru.aoklimov.threads.synchronize;

public class BlockingPrinter {

    private Integer a = 0;

    public synchronized void inc() {
        System.out.println(++a);
    }
}
