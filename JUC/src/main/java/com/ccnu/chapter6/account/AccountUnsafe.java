package com.ccnu.chapter6.account;

/**
 * Author: chs
 * Description: 账户（线程不安全）
 * CreateTime: 2024-08-10
 */
public class AccountUnsafe extends Account{
    private Integer balance;

    public AccountUnsafe(int balance){
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void withdraw(Integer amount) {
        balance -= amount;
    }

    public static void main(String[] args) {
        new AccountUnsafe(10000).demo();
    }
}
