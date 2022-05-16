package cn.yucheno8.jdbc.demo02JDBC;

import java.sql.*;

/**
 * @Author YUCHENO8
 * @Date 2022年03月15日 14:47
 * @Description
 */

/*
    执行DDL语句
 */
public class JDBCDemo07 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            // 3. 定义sql
            String sql = "select * from account";
            // 4. 获取执行sql的对象 Statement
            stmt = conn.createStatement();
            // 5. 执行sql
            rs = stmt.executeQuery(sql);
            // 6. 处理结果
            // 6.1 让游标向下移动一行
            /*if (rs.next()) {
                // 判断是否有数据
                // 6.2 获取数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);
                System.out.println(id + "---" + name + "---" + balance);
            }*/

            while (rs.next()) {
                // 循环判断游标是否是最后一行末尾
                // 6.2 获取数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);
                System.out.println(id + "---" + name + "---" + balance);
            }

            /*if (rs.next()) {
                // 判断是否有数据
                // 6.2 获取数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);
                System.out.println(id + "---" + name + "---" + balance);
            }*/




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. 释放资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
