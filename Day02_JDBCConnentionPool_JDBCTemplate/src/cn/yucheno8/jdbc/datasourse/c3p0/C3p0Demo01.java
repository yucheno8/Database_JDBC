package cn.yucheno8.jdbc.datasourse.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author YUCHENO8
 * @Date 2022年03月17日 12:03
 * @Description c3p0的演示
 */
public class C3p0Demo01 {
    public static void main(String[] args) throws SQLException {
        // 1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接对象
        Connection conn = ds.getConnection();

        // 3. 打印
        System.out.println(conn);
    }
}
