package com.shoaib.crateThread;

public class DownloadingHeartBeat extends Thread {
    private volatile boolean beating = true;

    @Override
    public void run() {
        String[] dots = {
                ".",
                "..",
                "...",
                "...."
        };
        while (beating){
            for (String dot : dots){
                System.out.println(dot);
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void shutdown(){
        this.beating = false;
    }
}
