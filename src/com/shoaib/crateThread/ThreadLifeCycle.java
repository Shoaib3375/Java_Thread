package com.shoaib.crateThread;

import java.util.concurrent.TimeUnit;

public class ThreadLifeCycle {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try{
                TimeUnit.MINUTES.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        t1.setName("MyThread # 1");
        t1.start();
        Thread t2 = new Thread(()->{
            while (!Thread.interrupted()){
                System.out.println("Running");
            }
        });
        t2.setName("MyThread # 2");
        t2.start();
        try {
            TimeUnit.MINUTES.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
