package cn.yucheno8.jdbc.Demo02JDBC;

/**
 * @Author YUCHENO8
 * @Date 2022年03月16日 10:49
 * @Description
 */

import cn.yucheno8.jdbc.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */
public class JDBCDemo10 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            // 1. 获取连接
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            // 2. 定义sql
            // 2.1 zhangsan - 500
            String sql1 = "update account set balance = balance - ? where id = ?";
            // 2.2 lisi + 500
            String sql2 = "update account set balance = balance + ? where id = ?";
            // 3. 获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            // 4. 设置参数
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);
            // 5. 执行sql
            pstmt1.executeUpdate();
            // 手动制造异常
            int i = 3 / 0;
            pstmt2.executeUpdate();
            // 提交事务
            conn.commit();

        } catch (Exception e) {
            // 事务回滚
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt1, null);
        }
    }
}
