package cn.bugstack.design.user.impl;

import cn.bugstack.design.user.User;
import cn.bugstack.design.visitor.Visitor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class Teacher extends User {

    public Teacher(String name, String identity, String clazz){
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public double entranceRatio(){
        return BigDecimal.valueOf(Math.random() * 100).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
