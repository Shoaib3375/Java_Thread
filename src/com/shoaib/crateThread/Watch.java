package com.shoaib.crateThread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Watch implements Runnable {
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running) {
            printCurrentTime();
            sleepOneSecond();
        }
    }
    private void sleepOneSecond() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
        String formattedCurrentTime = LocalDateTime.now().format(formatter);
        // print the current time
        System.out.println(formattedCurrentTime);
    }

    public void shutdown() {
        this.running = false;
    }
}
