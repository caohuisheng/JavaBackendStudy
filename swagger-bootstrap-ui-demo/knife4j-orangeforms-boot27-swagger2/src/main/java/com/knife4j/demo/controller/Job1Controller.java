/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.knife4j.demo.model.MyPageParam;
import com.knife4j.demo.model.SysUser;
import com.knife4j.demo.plugin.annotation.MyRequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Slf4j
@Api(tags = "测试接口1")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job1",produces = MediaType.APPLICATION_JSON_VALUE)
public class Job1Controller {


//    @ApiOperation(value = "api1",notes = "API_JOB_I18n_DESC")
//    @GetMapping("/api1")
//    public ResponseEntity<SysUser> api1(SysUser sysUser){
//        return ResponseEntity.ok(sysUser);
//    }


//    @ApiOperation(value = "api2-MyRequestBody",notes = "API_JOB_I18n_DESC")
//    @PostMapping("/api2")
//    public ResponseEntity<SysUser> api2(@MyRequestBody SysUser sysUser){
//        return ResponseEntity.ok(sysUser);
//    }

    @PostMapping("/list")
    public ResponseEntity<String> list(
            @MyRequestBody String loginName) {
        log.info("login-name:{}",loginName);
        return ResponseEntity.ok(loginName);
    }
//
//    @PostMapping("/list")
//    public ResponseEntity<MyPageParam> list(
//            @MyRequestBody String loginName, @MyRequestBody MyPageParam pageParam) {
//        log.info("login-name:{}",loginName);
//        return ResponseEntity.ok(pageParam);
//    }
}
