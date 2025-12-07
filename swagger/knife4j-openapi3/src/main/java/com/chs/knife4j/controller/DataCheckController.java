package com.chs.knife4j.controller;

import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.SchemaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.validation.Schema;

/**
 * @author: chs
 * @date: 2025-12-05 16:30
 * @description: todo
 */
@Tag(name = "DataCheckController", description = "测试数据校验相关接口")
@RestController
@RequestMapping("/test_data_check")
public class DataCheckController {

    @Operation(summary = "数据校验接口", description = "数据校验接口描述")
    @PostMapping("/data_check1")
    public Result<Void> dataCheck1(@RequestBody SchemaDTO body){
        System.out.println(body);
        return Result.success();
    }


}