package com.shoaib.ThreadSafetyDataSync;

import java.util.concurrent.TimeUnit;

public class SharedObject {
    private final ThreadLocal<Integer> number = new ThreadLocal<>();
    public Integer getNumber(){
        return number.get();
    }
    public void setNumber(Integer number){
        this.number.set(number);
    }

    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        setARandomNumber(sharedObject);

        Thread thread1 = new Thread(() -> setARandomNumber(sharedObject));
        Thread thread2 = new Thread(() -> setARandomNumber(sharedObject));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
        System.out.println("Thread: "+ Thread.currentThread().getName());
        System.out.println("Value: " + sharedObject.getNumber());
    }
    private static void setARandomNumber(SharedObject sharedObject){
        sharedObject.setNumber((int) (Math.random() * 100));
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Value: " + sharedObject.getNumber());
    }
}
