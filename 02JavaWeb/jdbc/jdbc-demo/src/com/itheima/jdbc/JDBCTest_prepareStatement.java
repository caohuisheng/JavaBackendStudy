package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCTest_prepareStatement{

    @Test
    public void log_Test() throws Exception{
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,username,password);
        //3.定义SQL语句
        String name = "zhangsan";
        String pwd = "1234";
        String sql = "select * from user where username = ? and password = ?";
        Thread.sleep(4000);
        System.out.println(sql);
        //4.获取SQL对象
        PreparedStatement stat = conn.prepareStatement(sql);

        //设置参数
        stat.setString(1,name);
        stat.setString(2,pwd);

        //执行查询
        ResultSet rs = stat.executeQuery();

        //6.处理返回结果
        if(rs.next()){
            System.out.println("login success");
        }else{
            System.out.println("login failed");
        }

        //7.释放资源
        stat.close();
        conn.close();
        rs.close();
    }

    @Test
    public void login() throws Exception{
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,username,password);
        //3.定义SQL语句
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        String sql = "select * from user where username = ? and password = ?";
        System.out.println(sql);
        //4.获取SQL对象
        PreparedStatement stat = conn.prepareStatement(sql);

        //设置参数
        stat.setString(1,name);
        stat.setString(2,pwd);

        //执行查询
        ResultSet rs = stat.executeQuery();

        //6.处理返回结果
        if(rs.next()){
            System.out.println("login success");
        }else{
            System.out.println("login failed");
        }

        //7.释放资源
        stat.close();
        conn.close();
        rs.close();
    }
}
