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
    }
}
