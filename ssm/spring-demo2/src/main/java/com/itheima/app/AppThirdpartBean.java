package com.itheima.app;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class AppThirdpartBean {

    public static void main(String[] args) {
        //加载配置类初始化容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println(ds);
    }
}
