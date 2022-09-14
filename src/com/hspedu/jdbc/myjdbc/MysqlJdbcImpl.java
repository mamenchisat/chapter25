package com.hspedu.jdbc.myjdbc;

/**
 * 项目名：    chapter25
 * 文件名：    MysqlJdbcImpl
 * 创建时间：   2022/9/13 17:38
 *
 * @author crazy Chen
 * 描述：  模拟mysql数据库实现jdbc    TODO
 */
public class MysqlJdbcImpl implements JdbcInterface {

    @Override
    public Object getConnection() {
        System.out.println("实现mysql数据库的连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("完成 mysql 增删改查");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql连接");
    }
}
