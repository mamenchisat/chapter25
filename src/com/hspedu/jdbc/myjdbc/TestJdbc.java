package com.hspedu.jdbc.myjdbc;

/**
 * 项目名：    chapter25
 * 文件名：    TestJdbc
 * 创建时间：   2022/9/13 17:41
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class TestJdbc {
    public static void main(String[] args) {
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
