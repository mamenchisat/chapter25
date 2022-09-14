package com.hspedu.dao_.dao;

import com.hspedu.jdbc.druid.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：    chapter25
 * 文件名：    BasicDAO
 * 创建时间：   2022/9/14 21:56
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class BasicDAO<T> {//泛型指定具体类型
    public QueryRunner queryRunner = new QueryRunner();

    //开发通用的dml方法。针对任意的表,返回受影响的行数
    public int update(String sql, Object... parameters) {
        int updateRows;
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回多个对象，针对任意表
    public List<T> queryForList(String sql, Class<T> clazz, Object... parameters) {
        List<T> list = new ArrayList<T>();
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回单行结果的对象，针对任意表
    public T queryForSingleRow(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    //返回单个值的结果的对象，针对任意表
    public Object queryForSingle(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
