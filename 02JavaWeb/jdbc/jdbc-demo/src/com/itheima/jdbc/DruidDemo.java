package com.itheima.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception{
        //获取配置文件
        Properties prop = new Properties();
        //加载配置文件
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        System.out.println(System.getProperty("user.dir"));
    }
}
