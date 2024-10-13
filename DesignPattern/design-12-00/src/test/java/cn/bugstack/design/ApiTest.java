package cn.bugstack.design;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class ApiTest {

    @Test
    public void test_IUserDao(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("10001");
        System.out.println("测试结果: " + res);
    }

}
