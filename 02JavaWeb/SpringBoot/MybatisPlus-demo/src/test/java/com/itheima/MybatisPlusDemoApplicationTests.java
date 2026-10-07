package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusDemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testFindAll() {
        //User user = userDao.selectById(1L);
        //List<User> users = userDao.selectList(null);
        //User user = userDao.selectById(1);
        //System.out.println(user);
        List<User> users = userDao.findAll();
        System.out.println(users);
    }

}
