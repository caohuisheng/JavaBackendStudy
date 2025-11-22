/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.new2;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.knife4j.demo.model.ModelUser;
import com.knife4j.demo.model.SysUser;
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
@Api(tags = "job1-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job1",produces = MediaType.APPLICATION_JSON_VALUE)
public class Job1Controller {




    @ApiOperation(value = "API_JOB_I18n",notes = "API_JOB_I18n_DESC")
    @GetMapping("/hidden")
    public ResponseEntity<SysUser> i18n(SysUser sysUser){
        return ResponseEntity.ok(sysUser);
    }


    @ApiOperation(value = "API_JOB_I18n",notes = "API_JOB_I18n_DESC")
    @PostMapping("/hidden1")
    public ResponseEntity<SysUser> i18n1(@RequestBody SysUser sysUser){
        return ResponseEntity.ok(sysUser);
    }





    @ApiOperation(value = "API_JOB_I18n",notes = "API_JOB_I18n_DESC")
    @GetMapping("/hidden2")
    public ResponseEntity<ModelUser> i18n2(ModelUser sysUser){
        return ResponseEntity.ok(sysUser);
    }


    @ApiOperation(value = "API_JOB_I18n",notes = "API_JOB_I18n_DESC")
    @PostMapping("/hidden3")
    public ResponseEntity<ModelUser> i18n3(@RequestBody ModelUser sysUser){
        return ResponseEntity.ok(sysUser);
    }

}
