/*
 * Copyright (C) 2022 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.knife4j.demo.new3;

import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/12/11 20:01
 */
@Slf4j
@Api(tags = "job4-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 279)
@RestController
@RequestMapping(value = "/job4",produces = MediaType.APPLICATION_JSON_VALUE)
public class Job4Controller {

    @ApiOperation(value = "ts结尾方法")
    @GetMapping("/methodts")
    public ResponseEntity<String> methodts(){
        return ResponseEntity.ok(RandomUtil.randomNumbers(22));
    }

    @ApiOperation(value = "非ts结尾方法")
    @GetMapping("/method")
    public ResponseEntity<String> methodt1s(){
        return ResponseEntity.ok(RandomUtil.randomNumbers(22));
    }
}
