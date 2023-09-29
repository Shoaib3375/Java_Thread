package com.shoaib.ThreadSafetyDataSync.RaceCondition_CriticalSection;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        Thread depositThread = new Thread(()-> {
            for (int i = 0; i < 100; i++){
                bankAccount.deposit(100);
                sleep();
            }
        });
        Thread withdrawThread = new Thread(()-> {
            for (int i = 0; i < 100; i++){
                bankAccount.withdraw(100);
                sleep();
            }
        });
        depositThread.start();
        withdrawThread.start();
        try {
            depositThread.join();
            withdrawThread.join();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
        System.out.println("Current balance available is account: " + bankAccount.getBalance());
    }
    public static void sleep(){
        try{
            Thread.sleep(1);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
