package com.itheima.service;

public interface AccountService {
    //转账
    void transfer(String from,String to,int money);
}
