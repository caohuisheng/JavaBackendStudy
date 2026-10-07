package com.example.dao;

import com.example.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {

    @Select("select * from tbl_book where id = #{id}")
    public Book findById(int id);

    @Select("select * from tbl_book")
    public List<Book> findAll();
}
