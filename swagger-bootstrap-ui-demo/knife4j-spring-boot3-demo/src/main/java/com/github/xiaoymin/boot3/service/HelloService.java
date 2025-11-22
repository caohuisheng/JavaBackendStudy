package com.github.xiaoymin.boot3.service;

import com.github.xiaoymin.boot3.model.FileResp;
import com.github.xiaoymin.boot3.model.Rest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/8/1 14:53
 * @since knife4j-spring-boot3-demo
 */
@Slf4j
@Component
public class HelloService {

    public Map<String,Object> test3(Rest<FileResp> fileResp, String name, Integer age){
        log.info("name:{},age:{}",name,age);
        Map<String,Object> value=new HashMap<>();
        value.put("name3",name);
        value.put("age3",age);
        value.put("uuid3", UUID.randomUUID().toString());
        value.put("file3",fileResp);
        return value;
    }

    public Map<String,Object> test2(FileResp fileResp, String name, Integer age){
        log.info("name:{},age:{}",name,age);
        Map<String,Object> value=new HashMap<>();
        value.put("name2",name);
        value.put("age2",age);
        value.put("uuid2", UUID.randomUUID().toString());
        value.put("file",fileResp);
        return value;
    }

    public Map<String,Object> test1(String name, Integer age){
        log.info("name:{},age:{}",name,age);
        Map<String,Object> value=new HashMap<>();
        value.put("name1",name);
        value.put("age1",age);
        value.put("uuid1", UUID.randomUUID().toString());
        return value;
    }
    public Map<String,Object> test(String name, String age){
      log.info("name:{},age:{}",name,age);
      Map<String,Object> value=new HashMap<>();
      value.put("name",name);
      value.put("age",age);
      value.put("uuid", UUID.randomUUID().toString());
      return value;
    }
}
