package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*
    登陆
     */
    public User login(String username,String password){
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.select(username,password);

        //释放资源
        sqlSession.close();
        return user;
    }

    /*
    注册
     */
    public boolean register(User user){
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User u = mapper.selectByUsername(user.getUsername());
        //如果用户不存在
        if(u == null){
            mapper.add(user);
            sqlSession.commit();
        }
        return u == null;
    }
}
