package com.shoaib.crateThread;

public class WatchTwoDemo {
    public static void main(String[] args)  throws InterruptedException{
        WatchTwo watchTwo = new WatchTwo();
        Thread watchThread = new Thread(watchTwo);
        watchThread.start();

        Thread.sleep(6000);
        watchTwo.shutdown();
    }
}
