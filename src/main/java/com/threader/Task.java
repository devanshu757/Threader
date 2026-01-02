package com.threader;

public class Task implements Runnable {

    private final String taskId;

    public Task(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() +
                " executing task: " + taskId
        );

        try {
            Thread.sleep(1000); // Simulate processing
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task interrupted: " + taskId);
        }
    }
}
