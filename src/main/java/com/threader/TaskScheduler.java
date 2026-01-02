package com.threader;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskScheduler {

    private final BlockingQueue<Task> taskQueue;

    public TaskScheduler(int workerCount) {
        taskQueue = new LinkedBlockingQueue<>();

        for (int i = 1; i <= workerCount; i++) {
            Thread workerThread = new Thread(
                    new Worker(taskQueue),
                    "Worker-" + i
            );
            workerThread.start();
        }
    }

    public void submitTask(Task task) {
        taskQueue.offer(task);
    }
}
