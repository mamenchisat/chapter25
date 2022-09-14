package com.hspedu.dao_.domain_;

import java.util.Date;

/**
 * 项目名：    chapter25
 * 文件名：    Actor
 * 创建时间：   2022/9/14 19:09
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class Actor {
    private String name;
    private String phone;
    private String sex;
    private Integer id;
    private Date borndata;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nActor{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", id=" + id +
                ", borndata=" + borndata +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBorndata() {
        return borndata;
    }

    public void setBorndata(Date borndata) {
        this.borndata = borndata;
    }

    public Actor(String name, String phone, String sex, Integer id, Date borndata) {
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.id = id;
        this.borndata = borndata;
    }

    public Actor() {
    }
}
