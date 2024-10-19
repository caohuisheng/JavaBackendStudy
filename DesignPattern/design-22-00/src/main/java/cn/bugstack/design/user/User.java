package cn.bugstack.design.user;

import cn.bugstack.design.visitor.Visitor;

/**
 * Author: chs
 * Description: 基础用户信息
 * CreateTime: 2024-10-19
 */
public abstract class User {

    public String name;     //姓名
    public String identity; //身份：重点班、普通版 | 特级教师、普通教师、实习教师
    public String clazz;    //班级

    public User(String name, String identity, String clazz){
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    public abstract void accept(Visitor visitor);

}
