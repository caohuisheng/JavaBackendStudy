package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
//@TableName("user")
public interface UserDao extends BaseMapper<User> {
    @Select("select * from user")
    public List<User> findAll();
}
