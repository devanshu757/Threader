package com.threader;

import java.util.concurrent.BlockingQueue;

public class TaskScheduler {

    private final BlockingQueue<Task> taskQueue;
    private final Thread[] workers;
    private volatile boolean isRunning = true;

    public TaskScheduler(int workerCount) {
        taskQueue = new java.util.concurrent.PriorityBlockingQueue<>();

        workers = new Thread[workerCount];

        for (int i = 0; i < workerCount; i++) {
            workers[i] = new Thread(
                    new Worker(taskQueue, this),
                    "Worker-" + (i + 1)
            );
            workers[i].start();
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void submitTask(Task task) {
        if (isRunning) {
            taskQueue.offer(task);
        }
    }

    public void shutdown() {
        isRunning = false;
        for (Thread worker : workers) {
            worker.interrupt();
        }
        System.out.println("Scheduler shutdown initiated.");
    }
}
