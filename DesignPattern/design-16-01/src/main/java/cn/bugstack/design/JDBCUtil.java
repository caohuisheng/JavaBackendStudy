package cn.bugstack.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-15
 */
public class JDBCUtil {

    private static Logger log = LoggerFactory.getLogger(JDBCUtil.class);

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/db1";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from account");
        while(resultSet.next()){
            log.info("测试结果 name:{} money:{}", resultSet.getString("name"), resultSet.getDouble("money"));
        }
    }

}
