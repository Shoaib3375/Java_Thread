package com.shoaib.Intro;

public class MainThreadExample {
    public static void main(String[] args) {
        Thread currentThread  = Thread.currentThread();
        System.out.println("Current thread Name: "+ currentThread.getName());
    }
}
