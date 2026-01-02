package com.threader;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        TaskScheduler scheduler = new TaskScheduler(3);

        scheduler.submitTask(new Task("Task-A", 1));
        scheduler.submitTask(new Task("Task-B", 3));
        scheduler.submitTask(new Task("Task-C", 2));
        scheduler.submitTask(new Task("Task-D", 5));

        Thread.sleep(5000); // Let tasks execute

        scheduler.shutdown();

        System.out.println(
            "Total tasks completed: " +
            Metrics.getCompletedTasks()
        );
    }
}
