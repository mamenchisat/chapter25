package com.hspedu.jdbc.druid;


import com.hspedu.jdbc.jdbcutils.JDBCUtils;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 项目名：    chapter25
 * 文件名：    DruidUse
 * 创建时间：   2022/9/14 16:30
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class DruidUse {
    @Test
    public void testDML(){
        //得到连接
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // 执行sql
        String sql = "update actor set sex = ? where id = ?";
        //创建preparedStatement
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "男");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(null, preparedStatement, connection);
        }

    }
    @Test
    public void testSelectToArrayList() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Actor> list = new ArrayList<>();

        //得到连接
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
                Integer id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndata = set.getDate("borndata");
                String phone = set.getString("phone");
                //把得到的actor对象封装，放入集合
                list.add(new Actor(name, phone, sex, id, borndata));
            }
            System.out.println(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }

    }
}
