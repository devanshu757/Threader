package com.threader;

public class Task implements Runnable, Comparable<Task> {

    private final String taskId;
    private final int priority;

    public Task(String taskId, int priority) {
        this.taskId = taskId;
        this.priority = priority;
    }

    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() +
                " executing " + taskId +
                " with priority " + priority
        );

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(other.priority, this.priority);
    }
}
