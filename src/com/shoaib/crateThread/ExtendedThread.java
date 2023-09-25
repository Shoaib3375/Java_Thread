package com.shoaib.crateThread;

import java.util.concurrent.TimeUnit;

public class ExtendedThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 5; i++){
            System.out.println("[" + i + " ] Inside " + Thread.currentThread().getName() );
            sleepOneSecond();
        }
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("Thread name: " + currentThreadName);
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
