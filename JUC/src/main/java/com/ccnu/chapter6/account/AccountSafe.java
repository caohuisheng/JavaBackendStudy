package com.ccnu.chapter6.account;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: chs
 * Description: 账户（线程安全）
 * CreateTime: 2024-08-10
 */
public class AccountSafe extends Account{
    private AtomicInteger balance;

    public AccountSafe(Integer balance){
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        //while(true){
        //    int prev = balance.get();
        //    int next = prev -= amount;
        //    if(balance.compareAndSet(prev, next)){
        //        break;
        //    }
        //}
        balance.addAndGet(-amount);
    }

    public static void main(String[] args) {
        new AccountSafe(10000).demo();
    }
}
