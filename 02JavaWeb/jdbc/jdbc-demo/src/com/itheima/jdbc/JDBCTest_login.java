package com.itheima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest_login {

    public static void main(String[] args) throws Exception{

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
        String sql = "select * from user where username = '"+name+"' and password = '"+pwd+"'";
        System.out.println(sql);
        //4.获取SQL对象
        Statement stat = conn.createStatement();

        //5.执行SQL
        ResultSet rs = stat.executeQuery(sql);

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
