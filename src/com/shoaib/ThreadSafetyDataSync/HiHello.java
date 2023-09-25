package com.shoaib.ThreadSafetyDataSync;

public class HiHello {
    static boolean s = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (!s){
            }
            System.out.println("Hello");
        });
        t1.start();

        Thread t2 = new Thread(()->{
            s = true;
            System.out.println("HI");
        });
        t2.start();
    }
}
