package com.threader;

import java.util.concurrent.atomic.AtomicInteger;

public class Metrics {

    private static final AtomicInteger completedTasks = new AtomicInteger(0);

    public static void incrementCompletedTasks() {
        completedTasks.incrementAndGet();
    }

    public static int getCompletedTasks() {
        return completedTasks.get();
    }
}
