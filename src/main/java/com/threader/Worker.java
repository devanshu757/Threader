package com.threader;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {

    private final BlockingQueue<Task> taskQueue;
    private final TaskScheduler scheduler;

    public Worker(BlockingQueue<Task> taskQueue, TaskScheduler scheduler) {
        this.taskQueue = taskQueue;
        this.scheduler = scheduler;
    }

    @Override
    public void run() {
        try {
            while (scheduler.isRunning() || !taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                if (task != null) {
                    task.run();
                    Metrics.incrementCompletedTasks();
                }
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " stopped.");
    }
}
