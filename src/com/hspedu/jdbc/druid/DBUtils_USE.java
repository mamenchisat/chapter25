package com.hspedu.jdbc.druid;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 项目名：    chapter25
 * 文件名：    DBUtils_USE
 * 创建时间：   2022/9/14 19:24
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class DBUtils_USE {
    @Test
    //使用apache-DBUtils 工具类 +druid 完成对表的crud
    public void testQueryMany() {//返回结果是多行数据
        String sql = "select * from actor where id = ? or ?";
        try {
            Connection connection = JDBCUtilsByDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();//执行查询返回arraylist结果集
            //1，query 方法就是执行sql语句，得到resultset 封装到arraylist集合中
            //2.返回集合
            //3.connection 连接
            //sql：执行的语句
            //new BeanListHandler<>(Actor.class)。在将resultset取出来放入actor对象，然后封装到arraylist对象，利用反射获取actor类的属性进行封装
            //params给？赋值，可以有多个
            List<Actor> actors = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1, 2);
            for (Actor actor :actors) {
                System.out.println(actor);
            }
            //释放资源
            JDBCUtilsByDruid.close(null,null,connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    //返回的是单行对象
    public void testQuerySingle() {
        String sql = "select * from actor where id = ?";
        try {
            Connection connection = JDBCUtilsByDruid.getConnection();
            QueryRunner queryRunner = new QueryRunner();//执行查询返回arraylist结果集
            //1，query 方法就是执行sql语句，得到resultset 封装到arraylist集合中
            //2.返回集合
            //3.connection 连接
            //sql：执行的语句
            //new BeanListHandler<>(Actor.class)。在将resultset取出来放入actor对象，然后封装到arraylist对象，利用反射获取actor类的属性进行封装
            //params给？赋值，可以有多个
            Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 1);
            System.out.println(actor);
            //释放资源
            JDBCUtilsByDruid.close(null,null,connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
