package ru.aoklimov.threads.runnable;

public class Incrementer3000 implements Runnable {

    private int value;
    private Integer times;

    public Incrementer3000(int value, Integer times) {
        this.value = value;
        this.times = times;
    }

    @Override
    public void run() {

        for (Integer i = 0; i < times; i++) {
            value += 1;
            System.out.println(value + " : " + Thread.currentThread().getName());
        }
    }
}
