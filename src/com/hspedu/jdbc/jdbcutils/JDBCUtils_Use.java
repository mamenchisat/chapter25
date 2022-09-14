package com.hspedu.jdbc.jdbcutils;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 项目名：    chapter25
 * 文件名：    JDBCUtils_Use
 * 创建时间：   2022/9/14 10:29
 *
 * @author crazy Chen
 * 描述：  测试JDBCUtils    TODO
 */
public class JDBCUtils_Use {
    @Test
    public void testDML(){
        //得到连接
        Connection connection = JDBCUtils.getConnection();
        // 执行sql
        String sql = "update actor set sex = ? where id = ?";
        //创建preparedStatement
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "女");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }

    }
    @Test
    public void testSelect() {
        Scanner scanner = new Scanner(System.in);

        //得到连接
        Connection connection = JDBCUtils.getConnection();
        // 执行sql
        String sql = "select * from actor where id = ? or ?";
        //创建preparedStatement
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "2");
            set = preparedStatement.executeQuery();
            while (set.next()) {
                String id = set.getString("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                String borndata = set.getString("borndata");
                String phone = set.getString("phone");
                System.out.println(id+"\t"+name+"\t"+sex+"\t"+borndata+"\t"+phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(set, preparedStatement, connection);
        }

    }
}
