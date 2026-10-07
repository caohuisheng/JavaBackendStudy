package com.example;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusDemo1ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll() {
        //List<User> users = userDao.selectList(null);
        //User user = userDao.selectById(1L);
        //List<User> users = userDao.selectList(null);
        //User user = userDao.selectById(1);
        //System.out.println(user);
//        List<User> users = userDao.selectList(null);
//        System.out.println(users);
        List<User> users = userDao.findAll();
        userDao.selectById(1);
        System.out.println(users);

        IPage page = new Page(1,3);
    }

}
