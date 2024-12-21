package com.heima.redis.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-12-21
 */
@Data
public class Student implements Serializable{
    private String name;
    private Integer age;

    public Student(){
    }

    public Student(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}


