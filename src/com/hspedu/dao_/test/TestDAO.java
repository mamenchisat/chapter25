package com.hspedu.dao_.test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.dao_.domain_.Actor;
import org.testng.annotations.Test;

import java.util.List;

/**
 * 项目名：    chapter25
 * 文件名：    TestDAO
 * 创建时间：   2022/9/14 22:22
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class TestDAO {
    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        List<Actor> actors = actorDAO.queryForList("select * from actor where id > ?", Actor.class, 0);
        for (Actor actor : actors) {
            System.out.println(actor);
        }
        //2. 查询单行记录
        Actor actor = actorDAO.queryForSingleRow("select * from actor where id = ?", Actor.class, 1);
        System.out.println("====查询单行结果====");
        System.out.println(actor);

        //3. 查询单行单列
        Object o = actorDAO.queryForSingle("select name from actor where id = ?", 2);
        System.out.println("====查询单行单列值===");
        System.out.println(o);

        //4. dml操作  insert ,update, delete
        int update = actorDAO.update("insert into actor values(null, ?, ?, ?, ?)", "domain", "女", "2000-11-11", "999");

        System.out.println(update > 0 ? "执行成功" : "执行没有影响表");

    }
}
