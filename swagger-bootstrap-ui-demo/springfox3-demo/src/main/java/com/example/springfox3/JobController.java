/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.example.springfox3;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Slf4j
@Api(tags = "job-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job",produces = MediaType.APPLICATION_JSON_VALUE)
public class JobController {

    @Autowired MessageSource messageSource;

    @ApiOperation(value = "API_JOB_I18n",notes = "API_JOB_I18n_DESC")
    @GetMapping("/i18n")
    public ResponseEntity<String> i18n(){
        return ResponseEntity.ok(messageSource.getMessage("API_JOB_TAG",null, Locale.CHINA));
    }

    @ApiOperation(value = "动态参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",example = "张飞",dataTypeClass = String.class),
            @ApiImplicitParam(name = "money",value = "金钱",example = "123",dataTypeClass = Long.class),
            @ApiImplicitParam(name = "age",value = "年龄",example = "22",dataTypeClass = Integer.class)

    })
    @PostMapping("/params")
    public ResponseEntity<Map<String,String>> params(@ApiIgnore @RequestParam Map<String,String> value){
        return ResponseEntity.ok(value);
    }

    @PostMapping("/orderList")
    public ResponseEntity<String> orderList(HttpServletRequest request){
        log.info("aaa");
        List<String> headerNames= CollectionUtil.newArrayList(request.getHeaderNames());
        for (String header:headerNames){
            log.info("header:{},value:{}",header, StrUtil.join(";",CollectionUtil.newArrayList(request.getHeaders(header))));
        }
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }


    @ApiOperation(value = "测试斜杠/abb")
    @PostMapping("/orderList1")
    public ResponseEntity<String> orderList1(){
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }


}
