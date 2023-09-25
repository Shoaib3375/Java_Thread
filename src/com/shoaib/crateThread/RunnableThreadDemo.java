package com.shoaib.crateThread;

import java.util.concurrent.TimeUnit;

public class RunnableThreadDemo {
    public static void main(String[] args) {
        MyThreadRunnable myThreadRunnable = new MyThreadRunnable();

        Thread thread = new Thread(myThreadRunnable);
        thread.setName("Runnable Thread");
        thread.start();

        for (int i = 0; i < 5; i++){
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }
    private static void sleepOneSecond(){
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
