package com.threader;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {

    private final BlockingQueue<Task> taskQueue;

    public Worker(BlockingQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = taskQueue.take(); // Thread-safe blocking call
                task.run();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(
                Thread.currentThread().getName() + " stopped."
            );
        }
    }
}
