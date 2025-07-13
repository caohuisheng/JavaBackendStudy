package com.itheima.service.impl;

import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public void transferMoney(String from, String to, Integer money) {
        accountMapper.decrMoney(from,money);
        // int i=1/0;
        accountMapper.incrMoney(to,money);
    }
}
