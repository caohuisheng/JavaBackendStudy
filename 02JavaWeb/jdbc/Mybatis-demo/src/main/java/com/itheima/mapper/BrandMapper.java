package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    //查询所有
    public List<Brand> selectAll();

    //查看详情
    public Brand selectById(int id);

    //条件查询
    //List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName,@Param("brandName")String brandName);
    //List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    //单条件查询
    List<Brand> selectByConditionSingle(Brand brand);

    //插入数据
    void insertItem(Brand brand);

    //更新数据
    int updateItem(Brand brand);

    //删除数据
    int deleteById(int id);

    //批量删除数据
    int deleteByIds(int[] id);
}

