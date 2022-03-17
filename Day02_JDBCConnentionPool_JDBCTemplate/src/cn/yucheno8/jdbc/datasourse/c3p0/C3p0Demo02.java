package cn.yucheno8.jdbc.datasourse.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author YUCHENO8
 * @Date 2022年03月17日 12:18
 * @Description C3p0演示
 */
public class C3p0Demo02 {
    public static void main(String[] args) throws SQLException {
        /*// 1. 获取DataSource，使用默认配置
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
            if (i == 5) {
                conn.close(); // 归还连接到连接池中
            }
        }*/

        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        // 1.1 获取DataSource，使用指定名称的配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        // 获取连接
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

        }
    }
}