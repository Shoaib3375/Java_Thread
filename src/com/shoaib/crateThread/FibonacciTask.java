package com.shoaib.crateThread;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FibonacciTask implements Runnable{
    private final long n;
    private final String id;
    public FibonacciTask(long n, String id){
        this.n = n;
        this.id = id;
    }
    private BigDecimal fib(long n){
        if (n==0){
            return BigDecimal.ZERO;
        } else if (n ==1) {
            return BigDecimal.ONE;
        }else {
            return fib(n-1).add(fib(n-2));
        }
    }
    @Override
    public void run(){
        DateTimeFormatter isoFromatter = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println("String task " + id + " at " + isoFromatter.format(LocalDateTime.now()));
        BigDecimal fib = fib(n);
        System.out.println("Ending task " + id + " at " + isoFromatter.format(LocalDateTime.now()));
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new FibonacciTask(45, "FibonacciTask# 1"));
        Thread t2 = new Thread(new FibonacciTask(45, "FibonacciTask# 2"));
//        Thread t3 = new Thread(new FibonacciTask(45, "FibonacciTask# 3"));
//        Thread t4 = new Thread(new FibonacciTask(45, "FibonacciTask# 4"));
//        Thread t5 = new Thread(new FibonacciTask(45, "FibonacciTask# 5"));
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
    }
}
