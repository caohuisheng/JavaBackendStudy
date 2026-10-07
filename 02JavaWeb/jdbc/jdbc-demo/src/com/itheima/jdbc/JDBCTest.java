package com.itheima.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTest {

    public static void main(String[] args) throws Exception{

        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,username,password);
        //3.定义SQL语句
        String sql = "update account set money = 2000 where id = 1";
        //4.获取SQL对象
        Statement stat = conn.createStatement();

        //5.执行SQL
        int count = stat.executeUpdate(sql);

        //6.处理返回结果
        System.out.println(count);

        //7.释放资源
        stat.close();
        conn.close();
    }
}
