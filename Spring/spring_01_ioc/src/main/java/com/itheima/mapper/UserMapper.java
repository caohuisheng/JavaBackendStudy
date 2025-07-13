package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

// @Mapper
public interface UserMapper {

    // @Select("select * from tb_user")
    List<User> selectAll();

}
