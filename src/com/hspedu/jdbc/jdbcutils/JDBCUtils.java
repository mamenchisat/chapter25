package com.hspedu.jdbc.jdbcutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 项目名：    chapter25
 * 文件名：    JDBCUtils
 * 创建时间：   2022/9/14 10:14
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    //在static代码块去初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //编写方法连接数据库
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    /*
          1.ResultSet结果集
          2.Statement 或者PreparedStatement
          3.Connection
          4.如果需要关闭资源，就传入对象，否则传入null
     */
    public static void close(ResultSet resultSet, Statement statement,Connection connection) {
        //判断是否null
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
