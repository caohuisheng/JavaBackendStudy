package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Transactional //开启事务
    @Override
    public void transfer(String from, String to, int money) {
        accountDao.outMoney(from,money);
        int i = 1/0;
        accountDao.inMoney(to,money);
    }
}
