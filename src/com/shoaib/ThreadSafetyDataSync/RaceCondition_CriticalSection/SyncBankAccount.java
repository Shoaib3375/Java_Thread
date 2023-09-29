package com.shoaib.ThreadSafetyDataSync.RaceCondition_CriticalSection;

public class SyncBankAccount {
    private long balance;
    public SyncBankAccount(long initialAmount){
        this.balance = initialAmount;
    }
    public synchronized void withdraw(long amount){
        System.out.println("Withdrawind " + amount);
        long newBalance = balance - amount;
        System.out.println("New balance is: " + newBalance);
        balance = newBalance;
    }
    public synchronized void deposit(long amount){
        System.out.println("Depositing " + amount);
        long newBalance = balance + amount;
        System.out.println("New balance is: " + newBalance);
        balance = newBalance;
    }
    public long getBalance(){
        return balance;
    }
}
