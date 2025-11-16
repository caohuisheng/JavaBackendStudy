package com.itheima.service;

import com.itheima.pojo.Account;

import java.io.IOException;
import java.util.List;

public interface AccountService {
    void save(Account account);

    void delete(Integer id);

    void update(Account account);

    List<Account> findAll();

    Account findById(Integer id);

    void transfer(String in,String out,double money) throws IOException;

}
