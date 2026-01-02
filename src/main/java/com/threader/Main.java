package com.threader;

public class Main {

    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler(3);

        for (int i = 1; i <= 10; i++) {
            scheduler.submitTask(
                    new Task("Task-" + i)
            );
        }
    }
}
