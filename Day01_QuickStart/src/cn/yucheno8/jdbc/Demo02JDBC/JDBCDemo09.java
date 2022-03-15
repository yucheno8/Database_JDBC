package cn.yucheno8.jdbc.Demo02JDBC;

import cn.yucheno8.jdbc.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author YUCHENO8
 * @Date 2022年03月15日 19:07
 * @Description
 */

/*
    需求：
        1. 通过键盘录入用户名和密码
        2. 判断用户是否登录成功
            * select * from user where username = "" and password = "";
            * 如果这个sql有查询结果，则成功，反之，则失败
 */
public class JDBCDemo09 {
    public static void main(String[] args) {
        // 1. 键盘录入，接受用户名和密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        // 2. 调用方法
        boolean flag = new JDBCDemo09().login2(username, password);
        // 3. 判断结果，输出不同语句
        if (flag) {
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    /**
     * 登录方法
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        // 连接数据库判断是否登录成功
        try {
            // 1. 获取连接
            conn = JDBCUtils.getConnection();
            // 2. 定义sql
            String sql = "select * from user where username = '" + username + "' and password = '" + password + "'";
            // 3. 获取执行sql的对象
            stmt = conn.createStatement();
            // 4. 执行查询
            rs = stmt.executeQuery(sql);
            // 5. 判断
            /*if (rs.next()) { // 如果有下一行，则返回true
                return true;
            } else {
                return false;
            }*/
            return rs.next(); // 如果有下一行，则返回true
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return false;
    }

    /**
     * 登录方法，使用PreparedStatement实现
     */
    public boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // 连接数据库判断是否登录成功
        try {
            // 1. 获取连接
            conn = JDBCUtils.getConnection();
            // 2. 定义sql
            String sql = "select * from user where username = ? and password = ?";
            // 3. 获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            // 给?赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            // 4. 执行查询，不需要传递sql
            rs = pstmt.executeQuery();
            // 5. 判断
            /*if (rs.next()) { // 如果有下一行，则返回true
                return true;
            } else {
                return false;
            }*/
            return rs.next(); // 如果有下一行，则返回true
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return false;
    }
}
