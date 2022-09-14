package com.hspedu.jdbc.myjdbc;

/**
 * 项目名：    chapter25
 * 文件名：    JdbcInterface
 * 创建时间：   2022/9/13 17:35
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public interface JdbcInterface {
    //连接
    public Object getConnection() ;
    //crud
    public void crud();
    //关闭连接
    public void close();
}
