package cn.bugstack.design;

import cn.bugstack.design.mediator.*;
import cn.bugstack.design.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-17
 */
public class ApiTest {

    private Logger log = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_queryUserInfoById(){
        String resources = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resources);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            try {
                User user = sqlSession.selectOne("cn.bugstack.design.dao.IUserDao.queryUserInfoById", 1L);
                log.info("测试结果：{}", JSON.toJSONString(user));
            } finally {
                sqlSession.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_queryUserList(){
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            DefaultSqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession sqlSession = sqlSessionFactory.openSession();
            List<User> userList;
            try {
                User req = new User();
                req.setAge(18);
                userList = sqlSession.selectList("cn.bugstack.design.dao.IUserDao.queryUserList", req);
            } finally {
                sqlSession.close();
                reader.close();
            }
            log.info("测试结果：{}", JSON.toJSONString(userList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
