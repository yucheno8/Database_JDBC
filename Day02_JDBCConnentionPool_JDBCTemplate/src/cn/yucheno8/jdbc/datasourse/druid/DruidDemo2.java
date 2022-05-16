package cn.yucheno8.jdbc.datasourse.druid;

import cn.yucheno8.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author YUCHENO8
 * @Date 2022年03月17日 16:49
 * @Description 使用新的工具类
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 完成添加的操作：给account添加一条记录
         */

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1. 获取连接
            conn = JDBCUtils.getConnection();
            // 2. 定义sql
            String sql = "insert into account values(null, ?, ?)";
            // 3. 获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            // 4. 给?赋值
            pstmt.setString(1, "王五");
            pstmt.setDouble(2, 3000);
            // 5. 执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 释放资源
            JDBCUtils.close(pstmt, conn);
        }

    }
}
