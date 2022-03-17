package cn.yucheno8.jdbc.jdbctemplate;

import cn.yucheno8.jdbc.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author YUCHENO8
 * @Date 2022年03月17日 17:04
 * @Description JdbcTemplate 入门
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        // 1. 导入jar包
        // 2. 创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        // 3. 调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
