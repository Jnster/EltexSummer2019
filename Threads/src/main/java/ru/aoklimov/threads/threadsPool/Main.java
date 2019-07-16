package ru.aoklimov.threads.threadsPool;

import ru.aoklimov.threads.synchronize.BlockingPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(7);
        BlockingPrinter printer = new BlockingPrinter();

        execute(cachedThreadPool, printer);
        execute(fixedThreadPool, printer);
        execute(scheduledExecutorService, printer);
    }

    private static void execute(ExecutorService executorService, BlockingPrinter printer) {

        for (int i = 0; i < 20; i++) {

            executorService.submit(printer::inc);
        }

        executorService.shutdown();
    }
}
