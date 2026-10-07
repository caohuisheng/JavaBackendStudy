package com.itheima.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

// @Mapper
public interface AccountMapper {
    @Update("update account set money=money+#{money} where name=#{name}")
    void incrMoney(@Param("name") String name,@Param("money") Integer money);

    @Update("update account set money=money-#{money} where name=#{name}")
    void decrMoney(@Param("name")String name,@Param("money")Integer money);
}
