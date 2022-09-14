package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 项目名：    chapter25
 * 文件名：    Jdbc01
 * 创建时间：   2022/9/13 17:56
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        Driver driver = new Driver();
        //2.得到连接
        String url = "jdbc:mysql://localhost:3306/mysql_demo?characterEncoding=utf8";
        //将用户名和密码放入Properties对象,说明k是规定好的
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        Connection connect = driver.connect(url, properties);
        //3. 执行sql
        String sql = "insert into actor values(1, '刘德华', '男', '1970-11-11', '110')";
        //String sql = "update actor set name='周星驰' where id = 1";
        //String sql = "delete from actor where id = 1";
        //statement 用于执行静态SQL语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 如果是 dml语句，返回的就是影响行数

        System.out.println(rows > 0 ? "成功" : "失败");

        //4. 关闭连接资源
        statement.close();
        connect.close();
    }
}
