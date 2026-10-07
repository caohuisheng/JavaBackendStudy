package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.UserDao;
import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusDemo2ApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        userDao.selectById(1);
        System.out.println(users);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setAge(19);
        user.setName("yeqiu");
        user.setPassword("1234");
        user.setTel("18171318816");
        userDao.insert(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteById(1642901641673416706L);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        //user.setId(1L);
        user.setTel("123");
        user.setPassword("666");
        userDao.updateById(user);
    }

    @Test
    public void testSelectByPage(){
        //创建Ipage分页对象
        IPage<User> page = new Page<>(2,3);
        //分页查询
        userDao.selectPage(page, null);
        System.out.println("pages:"+page.getPages());
        System.out.println("records:"+page.getRecords());
    }

    @Test
    public void testGetAll(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        //条件查询
//        qw.lt("age",18);
//        //2
//        qw.lambda().lt(User::getAge,18);
//        //3
//        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
//        lqw.lt(User::getAge,18);

        //多条件
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.lt(User::getAge,18).gt(User::getAge,10);

        lqw.lt(User::getAge,18).or().gt(User::getAge,10);

        List<User> list = userDao.selectList(qw);
        System.out.println(list);
    }

    @Test
    public void selectSomeParam(){
        //投影
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.select(User::getAge,User::getName);
        List<User> users = userDao.selectList(lqw);
        System.out.println(users);
    }

    @Test
    void function(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        //聚合查询
        //qw.select("count(*) as count");
        //qw.select("max(age) as maxage");

        //分组查询
        qw.select("count(*) as count,tel");
        qw.groupBy("tel");
        List<Map<String, Object>> maps = userDao.selectMaps(qw);

        System.out.println(maps);
    }

    @Test
    void condition(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getAge,10).or().eq(User::getId,1L);
        lqw.between(User::getAge,10,17);

        lqw.like(User::getName,"J");
//        lqw.orderBy(true,true,);
        lqw.orderBy(true,true,User::getId);
//        lqw.orderBy()
        //lqw.in
        //System.out.println(maps);
    }

    @Test
    void test(){
        userDao.deleteById(1L);
    }

    @Test
    void test1(){
        User user = new User();
        user.setId(3L);
        user.setName("Jck666");
        user.setVersion(1);
        userDao.updateById(user);
    }

    @Test
    void testBatch(){
//        List<Long> ids = new ArrayList<>();
//        userDao.deleteBatchIds(ids);
        User user = new User();
        user.setName("lisa");
        user.setAge(12);
        user.setPassword("abc");
        user.setTel("12");
        user.setDeleted(0);
        user.setVersion(0);

        userDao.insert(user);
    }

    @Test
    void testLock(){
        //首先查询出数据
        User user1 = userDao.selectById(2);
        User user2 = userDao.selectById(2);

        user1.setName("aaa");
        user2.setName("bbb");

        //更新数据库，应该只有一个成功
        userDao.updateById(user1);
        userDao.updateById(user2);
    }

}
