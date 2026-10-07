package com.ccnu.chapter6.atomic_reference;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-08-10
 */
public class DecimalAccountSafe extends DecimalAccount{
    private AtomicReference<BigDecimal> balance;

    public DecimalAccountSafe(BigDecimal balance){
        this.balance = new AtomicReference<BigDecimal>(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while(true){
            BigDecimal prev = balance.get();
            BigDecimal next = prev.subtract(amount);
            if(balance.compareAndSet(prev, next)){
                break;
            }
        }
    }

    public static void main(String[] args) {
        new DecimalAccountSafe(new BigDecimal(10000)).demo();
    }
}
