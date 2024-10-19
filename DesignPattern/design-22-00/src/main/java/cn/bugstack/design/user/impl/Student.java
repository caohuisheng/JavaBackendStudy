package cn.bugstack.design.user.impl;

import cn.bugstack.design.user.User;
import cn.bugstack.design.visitor.Visitor;

/**
 * Author: chs
 * Description: 学生
 * CreateTime: 2024-10-19
 */
public class Student extends User {

    public Student(String name, String identity, String clazz){
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int ranking(){
        return (int)(Math.random() * 50);
    }
}
