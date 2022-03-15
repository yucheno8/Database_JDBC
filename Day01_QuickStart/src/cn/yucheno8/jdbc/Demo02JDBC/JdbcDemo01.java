package cn.yucheno8.jdbc.Demo02JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author YUCHENO8
 * @Date 2022年03月14日 20:36
 * @Description
 */

/*
    JDBC快速入门
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        // 1. 导入驱动jar包
        /*
            1）. 复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
            2）. 右键-->Add As Library
         */
        // 2. 注册驱动（注意：mysql5之后的驱动jar包可以省略注册驱动的步骤。）
        Class.forName("com.mysql.jdbc.Driver");
        // 3. 获取数据库连接对象
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");        // 4. 定义sql语句
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");        // 4. 定义sql语句
        //String sql = "update account set balance = 1000 where id = 1";
        String sql = "update account set balance = 2000";
        // 5. 获取执行sql的对象
        Statement stmt = conn.createStatement();
        // 6. 执行sql
        int count = stmt.executeUpdate(sql);
        // 7. 处理结果
        System.out.println(count);
        // 8. 释放资源
        stmt.close();
        conn.close();
    }
}
