package com.itheima.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itheima.jdbc.bean.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcPractice {

    @Test
    public void selectAll() throws Exception {
        //获取配置文件
        Properties prop = new Properties();
        //加载配置文件
        prop.load(new FileInputStream("D:/MUXI/javaCode/jdbc/jdbc-demo/src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();

        System.out.println(conn);

        //定义sql
        String sql = "select * from tb_brand;";
        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置参数

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //处理结果
        Brand brand = null;
        List<Brand> brandList = new ArrayList<>();
        while (rs.next()) {
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            brand = new Brand(brandName, companyName, ordered, description, status);
            brandList.add(brand);
        }
        System.out.println(brandList);
        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    @Test
    public void insertTest() throws Exception {
        //获取输入数据
        String brandName = "红米";
        String companyName = "小米";
        int ordered = 1;
        String desc = "为发烧而生";
        int status = 1;

        //获取配置文件
        Properties prop = new Properties();
        //加载配置文件
        prop.load(new FileInputStream("D:/MUXI/javaCode/jdbc/jdbc-demo/src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();


        //定义sql
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status)" +
                "values(?,?,?,?,?)";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, desc);
        pstmt.setInt(5, status);

        //执行sql
        int count = pstmt.executeUpdate();

        //处理结果
        System.out.println(count);
        //释放资源
        pstmt.close();
        conn.close();
    }

    @Test
    public void updateTest() throws Exception {
        //获取输入数据
        String brandName = "红米";
        String companyName = "小米";
        int ordered = 100;
        String desc = "为发烧而生";
        int status = 1;
        int id = 2;

        //获取配置文件
        Properties prop = new Properties();
        //加载配置文件
        prop.load(new FileInputStream("D:/MUXI/javaCode/jdbc/jdbc-demo/src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();


        //定义sql
        String sql = "update tb_brand set brand_name = ?," +
                "company_name = ?," +
                "ordered = ?," +
                "description = ?," +
                "status = ? " +
                "where id = ?;";
        System.out.println(sql);

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, desc);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        //执行sql
        int count = pstmt.executeUpdate();

        //处理结果
        System.out.println(count);
        //释放资源
        pstmt.close();
        conn.close();
    }

    @Test
    public void deleteTest() throws Exception {
        //获取输入数据
        int id = 4;

        //获取配置文件
        Properties prop = new Properties();
        //加载配置文件
        prop.load(new FileInputStream("D:/MUXI/javaCode/jdbc/jdbc-demo/src/druid.properties"));
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = dataSource.getConnection();

        //定义sql
        String sql = "delete from tb_brand where id = ?;";
        System.out.println(sql);

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置参数
        pstmt.setInt(1, id);

        //执行sql
        int count = pstmt.executeUpdate();

        //处理结果
        System.out.println(count);
        //释放资源
        pstmt.close();
        conn.close();
    }
}
