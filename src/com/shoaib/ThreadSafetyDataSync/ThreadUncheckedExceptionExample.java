package com.shoaib.ThreadSafetyDataSync;

import java.util.concurrent.TimeUnit;

public class ThreadUncheckedExceptionExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                System.err.println("Thread Interrupted deu to " + e.getMessage());
            }
            throw new RuntimeException("Goodbye cruel world!");
        });
        thread.setUncaughtExceptionHandler(new CustomUncaughtExceptionhandler());
        thread.start();
    }
}
