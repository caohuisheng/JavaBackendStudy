package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;

public interface userDao {
    @Insert("insert into tbl_user(name,age) values(#{name},#{age})")
    public void save(String name,int age);
}
